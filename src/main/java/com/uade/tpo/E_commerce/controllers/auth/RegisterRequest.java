package com.uade.tpo.E_commerce.controllers.auth;


import com.uade.tpo.E_commerce.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String username;
    private String mail;
    private String password;
    private Role role;
}
