package com.empresa.motoboy.controller;

import com.empresa.motoboy.dto.LojaRequestDTO;
import com.empresa.motoboy.dto.LojaResponseDTO;
import com.empresa.motoboy.model.Loja;
import com.empresa.motoboy.service.LojaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lojas")
@RequiredArgsConstructor
public class LojaController {

    private final LojaService lojaService;

    @PostMapping
    @Operation(summary = "Criar uma loja")
    public LojaResponseDTO criar(@RequestBody @Valid LojaRequestDTO dto) {
        return lojaService.criar(dto);
    }

    @GetMapping
    @Operation(summary = "Listar lojas")
    public List<Loja> listar() {
        return lojaService.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar loja por ID")
    public Loja buscarPorId(@PathVariable Long id) {
        return lojaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar loja")
    public LojaResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody @Valid LojaRequestDTO dto
    ) {
        return lojaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar loja")
    public void deletar(@PathVariable Long id) {
        lojaService.deletar(id);
    }
}