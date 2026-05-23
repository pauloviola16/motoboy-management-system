package com.empresa.motoboy.controller;

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

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute(
                "lojas",
                escalaService.buscarDashboard(LocalDate.now())
        );

        return "dashboard";
    }
}
