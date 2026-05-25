package com.empresa.motoboy.controller;

import com.empresa.motoboy.dto.MotoboyRequestDTO;
import com.empresa.motoboy.dto.MotoboyResponseDTO;
import com.empresa.motoboy.model.Motoboy;
import com.empresa.motoboy.service.MotoboyService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoboys")
@RequiredArgsConstructor
public class MotoboyController {

    private final MotoboyService motoboyService;

    @PostMapping
    @Operation(summary = "Criar um novo motoboy")
    public MotoboyResponseDTO criar(@RequestBody @Valid MotoboyRequestDTO dto) {
        return motoboyService.criar(dto);
    }

    @GetMapping
    @Operation(summary = "Buscar um motoboy")
    public List<Motoboy> listar() {
        return motoboyService.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um motoboy pelo ID")
    public Motoboy buscarPorId(@PathVariable Long id) {
        return motoboyService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um motoboy pelo ID")
    public Motoboy atualizar(
            @PathVariable Long id,
            @RequestBody @Valid Motoboy motoboy
    ) {
        return motoboyService.atualizar(id, motoboy);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um motoboy pelo ID")
    public void deletar(@PathVariable Long id) {
        motoboyService.deletar(id);
    }
}
