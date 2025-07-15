package com.deliverytech.delivery.dto.response;

import lombok.*;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteResponse {
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;

    private String categoria;
    private String telefone;
    private BigDecimal taxaEntrega;
    private Integer tempoEntregaMinutos;
    private Boolean ativo;
}
