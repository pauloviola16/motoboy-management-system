package com.empresa.motoboy.controller;

import com.empresa.motoboy.dto.EscalaFormDTO;
import com.empresa.motoboy.repository.LojaRepository;
import com.empresa.motoboy.repository.MotoboyRepository;
import com.empresa.motoboy.service.EscalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final EscalaService escalaService;
    private final MotoboyRepository motoboyRepository;
    private final LojaRepository lojaRepository;

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute(
                "lojas",
                escalaService.buscarDashboard(LocalDate.now())
        );

        return "dashboard";
    }

    @GetMapping("/escalas/nova")
    public String novaEscala(Model model) {

        model.addAttribute(
                "motoboys",
                motoboyRepository.findAll()
        );

        model.addAttribute(
                "lojas",
                lojaRepository.findAll()
        );

        model.addAttribute(
                "escala",
                new EscalaFormDTO()
        );

        return "nova-escala";
    }
}
