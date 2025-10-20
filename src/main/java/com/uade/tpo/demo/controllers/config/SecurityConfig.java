package com.uade.tpo.demo.controllers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.uade.tpo.demo.entity.Role;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(req -> req
                // Rutas públicas (sin autenticación)
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers("/error/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/categories/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/products/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/files/uploads/**").permitAll() // Permitir acceso a imágenes
                .requestMatchers(HttpMethod.GET, "/uploads/**").permitAll() // Permitir acceso a imágenes
                
                // Rutas de ADMIN
                .requestMatchers(HttpMethod.POST, "/products/**").hasAuthority(Role.ADMIN.name())
                .requestMatchers(HttpMethod.PUT, "/products/**").hasAuthority(Role.ADMIN.name())
                .requestMatchers(HttpMethod.DELETE, "/products/**").hasAuthority(Role.ADMIN.name())
                .requestMatchers("/categories/**").hasAuthority(Role.ADMIN.name())
                .requestMatchers("/files/**").hasAuthority(Role.ADMIN.name()) // Upload de archivos solo admin
                
                // Rutas de USER y ADMIN
                .requestMatchers(HttpMethod.POST, "/orders/**").hasAnyAuthority(Role.ADMIN.name(), Role.USER.name())
                .requestMatchers(HttpMethod.GET, "/orders/**").hasAnyAuthority(Role.ADMIN.name(), Role.USER.name())
                
                // Cualquier otra ruta requiere autenticación
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Permite ambos puertos para desarrollo
        configuration.setAllowedOrigins(List.of(
            "http://localhost:5173",
            "http://localhost:5174"
        ));
        
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}