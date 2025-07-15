package com.deliverytech.delivery.dto.request;

import java.util.List;

import com.deliverytech.delivery.model.Endereco;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {
    
    
    private Long clienteId;
    
    
    private Long restauranteId;
    
    @NotBlank(message = "O campo 'enderecoEntrega' não pode estar vazio")
    private Endereco enderecoEntrega;
    
    @NotBlank(message = "O campo 'itens' não pode estar vazio")
    private List<ItemPedidoRequest> itens;
}
