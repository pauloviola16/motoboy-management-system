package com.empresa.motoboy.controller;

import com.empresa.motoboy.dto.LoginRequestDTO;
import com.empresa.motoboy.dto.LoginResponseDTO;
import com.empresa.motoboy.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(
            @RequestBody @Valid LoginRequestDTO dto) {

        return authService.login(dto);
    }
}