package com.empresa.motoboy.controller;

import com.empresa.motoboy.dto.LoginRequestDTO;
import com.empresa.motoboy.dto.LoginResponseDTO;
import com.empresa.motoboy.dto.UsuarioRequestDTO;
import com.empresa.motoboy.model.Usuario;
import com.empresa.motoboy.service.AuthService;
import com.empresa.motoboy.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UsuarioService usuarioService;

    @PostMapping("/register")
    public Usuario cadastrar(
            @RequestBody @Valid UsuarioRequestDTO dto) {

        return usuarioService.cadastrar(dto);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
            @RequestBody @Valid LoginRequestDTO dto) {

        return authService.login(dto);
    }
}