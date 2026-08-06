package com.empresa.motoboy.controller;

import com.empresa.motoboy.dto.EscalaRequestDTO;
import com.empresa.motoboy.repository.LojaRepository;
import com.empresa.motoboy.repository.MotoboyRepository;
import com.empresa.motoboy.service.EscalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final EscalaService escalaService;
    private final MotoboyRepository motoboyRepository;
    private final LojaRepository lojaRepository;

    @GetMapping("/")
    public String dashboard(
            @RequestParam(required = false) LocalDate data,
            Model model
    ) {

        if (data == null) {
            data = LocalDate.now();
        }

        model.addAttribute(
                "dataSelecionada",
                data
        );

        model.addAttribute(
                "lojas",
                escalaService.buscarDashboard(data)
        );

        return "dashboard";
    }

    @GetMapping("/escalas/nova")
    public String novaEscala(
            @RequestParam(required = false) Long lojaId,
            @RequestParam(required = false) LocalDate data,
            Model model
    ) {

        EscalaRequestDTO dto = new EscalaRequestDTO();

        if (lojaId != null) {
            dto.setLojaId(lojaId);
        }

        if (data != null) {
            dto.setData(data);
        }

        model.addAttribute(
                "motoboys",
                motoboyRepository.findAll()
        );

        model.addAttribute(
                "escala",
                dto
        );

        return "nova-escala";
    }

    @PostMapping("/escalas/nova")
    public String criarEscalaFrontend(
            @ModelAttribute EscalaRequestDTO dto
    ) {

        escalaService.criar(dto);

        return "redirect:/";
    }

    @PostMapping("/escalas/{id}/excluir")
    public String excluirEscala(@PathVariable Long id) {

        escalaService.excluirEscala(id);

        return "redirect:/";
    }
}
