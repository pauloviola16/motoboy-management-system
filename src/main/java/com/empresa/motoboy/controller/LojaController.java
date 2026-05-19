package com.empresa.motoboy.controller;

import com.empresa.motoboy.model.Loja;
import com.empresa.motoboy.service.LojaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lojas")
@RequiredArgsConstructor
public class LojaController {

    private final LojaService lojaService;

    @PostMapping
    @Operation(summary = "Criar uma loja")
    public Loja criar(@RequestBody @Valid Loja loja) {
        return lojaService.criar(loja);
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
    public Loja atualizar(
            @PathVariable Long id,
            @RequestBody @Valid Loja loja
    ) {
        return lojaService.atualizar(id, loja);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar loja")
    public void deletar(@PathVariable Long id) {
        lojaService.deletar(id);
    }
}