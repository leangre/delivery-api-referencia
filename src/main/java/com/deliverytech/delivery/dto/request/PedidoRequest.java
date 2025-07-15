package com.deliverytech.delivery.dto.request;

import com.deliverytech.delivery.model.Endereco;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {
    private Long clienteId;
    private Long restauranteId;
    private Endereco enderecoEntrega;
    private List<ItemPedidoRequest> itens;
}
