package com.empresa.motoboy.controller;

import com.empresa.motoboy.dto.UsuarioRequestDTO;
import com.empresa.motoboy.model.Usuario;
import com.empresa.motoboy.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrar(@RequestBody UsuarioRequestDTO dto) {
        return usuarioService.cadastrar(dto);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario atualizar(
            @PathVariable Long id,
            @RequestBody UsuarioRequestDTO dto) {

        return usuarioService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

    @PutMapping("/{id}/promover-admin")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario promoverParaAdmin(@PathVariable Long id) {
        return usuarioService.promoverParaAdmin(id);
    }
}
