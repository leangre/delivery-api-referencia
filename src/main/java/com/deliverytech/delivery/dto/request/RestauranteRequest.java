package com.deliverytech.delivery.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteRequest {

    @NotBlank(message = "O nome do restaurante é obrigatório")
    private String nome;

    @NotBlank(message = "A categoria do restaurante é obrigatória")
    private String categoria;

    @NotBlank(message = "O telefone do restaurante é obrigatório")
    private String telefone;

    @DecimalMin(value = "0.0", message = "A taxa de entrega deve ser maior ou igual a zero")
    private BigDecimal taxaEntrega;

    @Min(5)
    @Max(60)
    private Integer tempoEntregaMinutos;
}
