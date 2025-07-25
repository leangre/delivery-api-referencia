package com.deliverytech.delivery.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.dto.request.RestauranteRequest;
import com.deliverytech.delivery.dto.response.RestauranteResponse;
import com.deliverytech.delivery.model.Restaurante;
import com.deliverytech.delivery.service.RestauranteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {

        private final RestauranteService restauranteService;

        @PostMapping
        public ResponseEntity<RestauranteResponse> cadastrar(@Valid @RequestBody RestauranteRequest request) {
                Restaurante restaurante = Restaurante.builder()
                                .nome(request.getNome())
                                .telefone(request.getTelefone())
                                .categoria(request.getCategoria())
                                .taxaEntrega(request.getTaxaEntrega())
                                .tempoEntregaMinutos(request.getTempoEntregaMinutos())
                                .ativo(true)
                                .build();
                Restaurante salvo = restauranteService.cadastrar(restaurante);
                return ResponseEntity.ok(new RestauranteResponse(
                                salvo.getId(), salvo.getNome(), salvo.getCategoria(), salvo.getTelefone(),
                                salvo.getTaxaEntrega(), salvo.getTempoEntregaMinutos(), salvo.getAtivo()));
        }

        @GetMapping
        public List<RestauranteResponse> listarTodos() {
                return restauranteService.listarTodos().stream()
                                .map(r -> new RestauranteResponse(r.getId(), r.getNome(), r.getCategoria(),
                                                r.getTelefone(),
                                                r.getTaxaEntrega(), r.getTempoEntregaMinutos(), r.getAtivo()))
                                .collect(Collectors.toList());
        }

        @GetMapping("/{id}")
        public ResponseEntity<RestauranteResponse> buscarPorId(@PathVariable Long id) {
                return restauranteService.buscarPorId(id)
                                .map(r -> new RestauranteResponse(r.getId(), r.getNome(), r.getCategoria(),
                                                r.getTelefone(),
                                                r.getTaxaEntrega(), r.getTempoEntregaMinutos(), r.getAtivo()))
                                .map(ResponseEntity::ok)
                                .orElse(ResponseEntity.notFound().build());
        }

        @GetMapping("/categoria/{categoria}")
        public List<RestauranteResponse> buscarPorCategoria(@PathVariable String categoria) {
                return restauranteService.buscarPorCategoria(categoria).stream()
                                .map(r -> new RestauranteResponse(r.getId(), r.getNome(), r.getCategoria(),
                                                r.getTelefone(),
                                                r.getTaxaEntrega(), r.getTempoEntregaMinutos(), r.getAtivo()))
                                .collect(Collectors.toList());
        }

        @PutMapping("/{id}")
        public ResponseEntity<RestauranteResponse> atualizar(@Valid @PathVariable Long id,
                        @RequestBody RestauranteRequest request) {
                Restaurante atualizado = Restaurante.builder()
                                .nome(request.getNome())
                                .telefone(request.getTelefone())
                                .categoria(request.getCategoria())
                                .taxaEntrega(request.getTaxaEntrega())
                                .tempoEntregaMinutos(request.getTempoEntregaMinutos())
                                .build();
                Restaurante salvo = restauranteService.atualizar(id, atualizado);
                return ResponseEntity.ok(new RestauranteResponse(salvo.getId(), salvo.getNome(), salvo.getCategoria(),
                                salvo.getTelefone(), salvo.getTaxaEntrega(), salvo.getTempoEntregaMinutos(),
                                salvo.getAtivo()));
        }
}