package com.deliverytech.delivery.service;

import com.deliverytech.delivery.model.Restaurante;

import java.util.List;
import java.util.Optional;

public interface RestauranteService {
    Restaurante cadastrar(Restaurante restaurante);

    Optional<Restaurante> buscarPorId(Long id);

    List<Restaurante> listarTodos();

    List<Restaurante> buscarPorCategoria(String categoria);

    Restaurante atualizar(Long id, Restaurante restauranteAtualizado);
}
