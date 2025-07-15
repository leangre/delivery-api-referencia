package com.deliverytech.delivery.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    
    @NotBlank(message = "O nome do produto não pode estar em branco")
    private String nome;
    
    @NotBlank(message = "A categoria do produto não pode estar em branco")
    private String categoria;
    
    @NotBlank(message = "A descrição do produto não pode estar em branco")
    private String descricao;
    
    @DecimalMin(value = "0.01", message = "O preço do produto deve ser maior que zero")
    private BigDecimal preco;
    
    private Long restauranteId;
}
