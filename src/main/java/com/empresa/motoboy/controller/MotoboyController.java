package com.empresa.motoboy.controller;

import com.empresa.motoboy.model.Motoboy;
import com.empresa.motoboy.service.MotoboyService;
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
    public Motoboy criar(@RequestBody @Valid Motoboy motoboy) {
        return motoboyService.criar(motoboy);
    }

    @GetMapping
    public List<Motoboy> listar() {
        return motoboyService.listar();
    }

    @GetMapping("/{id}")
    public Motoboy buscarPorId(@PathVariable Long id) {
        return motoboyService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Motoboy atualizar(
            @PathVariable Long id,
            @RequestBody @Valid Motoboy motoboy
    ) {
        return motoboyService.atualizar(id, motoboy);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        motoboyService.deletar(id);
    }
}
