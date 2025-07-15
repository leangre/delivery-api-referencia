package com.deliverytech.delivery.dto.request;

import java.util.List;

import com.deliverytech.delivery.model.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {
    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clienteId;

    @NotNull(message = "O ID do restaurante é obrigatório")
    private Long restauranteId;

    @NotBlank(message = "O endereço de entrega é obrigatório")
    private Endereco enderecoEntrega;

    @NotNull(message = "A lista de itens é obrigatória")
    private List<ItemPedidoRequest> itens;
}
