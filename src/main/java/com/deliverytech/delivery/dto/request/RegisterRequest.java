package com.deliverytech.delivery.dto.request;

import com.deliverytech.delivery.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String email;
    private String senha;
    private String nome;
    private Role role;
    private Long restauranteId;
}
