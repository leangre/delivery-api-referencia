package com.deliverytech.delivery.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private String nome;
    private String categoria;
    private String descricao;
    private BigDecimal preco;
    private Long restauranteId;
}
