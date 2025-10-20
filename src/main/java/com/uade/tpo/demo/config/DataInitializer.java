package com.uade.tpo.demo.config;

import com.uade.tpo.demo.entity.Category;
import com.uade.tpo.demo.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initCategories(CategoryRepository categoryRepository) {
        return args -> {
            // Verificar si ya existen categorías
            if (categoryRepository.count() == 0) {
                // Crear las categorías predeterminadas
                categoryRepository.save(new Category("Mate"));
                categoryRepository.save(new Category("Bombilla"));
                categoryRepository.save(new Category("Accesorio"));
                
                System.out.println("✅ Categorías inicializadas: Mate, Bombilla, Accesorio");
            } else {
                System.out.println("ℹ️ Las categorías ya existen en la base de datos");
            }
        };
    }
}
