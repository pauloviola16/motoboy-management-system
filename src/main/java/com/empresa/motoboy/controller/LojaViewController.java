package com.empresa.motoboy.controller;

import com.empresa.motoboy.dto.LojaRequestDTO;
import com.empresa.motoboy.model.Loja;
import com.empresa.motoboy.service.LojaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lojas")
@RequiredArgsConstructor
public class LojaViewController {

    private final LojaService lojaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lojas", lojaService.listar());
        return "lojas/lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("loja", new LojaRequestDTO());
        model.addAttribute("modoEdicao", false);
        return "lojas/form";
    }

    @PostMapping
    public String salvar(@ModelAttribute("loja") LojaRequestDTO dto) {
        lojaService.criar(dto);
        return "redirect:/lojas";
    }

    @GetMapping("/{id}/editar")
    public String editarForm(@PathVariable Long id, Model model) {
        Loja loja = lojaService.buscarPorId(id);
        LojaRequestDTO dto = new LojaRequestDTO(loja.getNome(), loja.getEndereco(), loja.getValorDiaria());
        model.addAttribute("loja", dto);
        model.addAttribute("lojaId", id);
        model.addAttribute("modoEdicao", true);
        return "lojas/form";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute("loja") LojaRequestDTO dto) {
        lojaService.atualizar(id, dto);
        return "redirect:/lojas";
    }

    @PostMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        lojaService.deletar(id);
        return "redirect:/lojas";
    }
}