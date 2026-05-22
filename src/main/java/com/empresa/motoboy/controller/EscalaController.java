package com.empresa.motoboy.controller;

import com.empresa.motoboy.dto.EscalaRequestDTO;
import com.empresa.motoboy.dto.LojaDashboardDTO;
import com.empresa.motoboy.model.Escala;
import com.empresa.motoboy.service.EscalaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/escalas")
@RequiredArgsConstructor
public class EscalaController {

    private final EscalaService escalaService;

    @PostMapping
    @Operation(summary = "Criar nova escala")
    public Escala criar(
            @RequestBody @Valid EscalaRequestDTO dto
    ) {

        return escalaService.criar(dto);
    }

    @PatchMapping("/{id}/cancelar")
    @Operation(summary = "Cancelar escala")
    public void cancelar(@PathVariable Long id) {

        escalaService.cancelarEscala(id);
    }

    @GetMapping("/dashboard")
    @Operation(summary = "Buscar dashboard das lojas")
    public List<LojaDashboardDTO> dashboard(

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate data
    ) {

        return escalaService.buscarDashboard(data);
    }
}
