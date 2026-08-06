package com.empresa.motoboy.controller;

import com.empresa.motoboy.dto.EscalaRequestDTO;
import com.empresa.motoboy.dto.LojaDashboardDTO;
import com.empresa.motoboy.model.Escala;
import com.empresa.motoboy.model.StatusEscala;
import com.empresa.motoboy.service.EscalaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/escalas")
@RequiredArgsConstructor
public class EscalaController {

    private final EscalaService escalaService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @Operation(summary = "Criar nova escala")
    public Escala criar(
            @RequestBody @Valid EscalaRequestDTO dto
    ) {

        return escalaService.criar(dto);
    }

    @PostMapping("/escalas/{id}/status")
    public String atualizarStatus(@PathVariable Long id, @RequestParam StatusEscala status) {
        escalaService.atualizarStatus(id, status);
        return "redirect:/";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
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
