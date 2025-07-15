package com.deliverytech.delivery.dto.request;

import com.deliverytech.delivery.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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
