package com.empresa.motoboy.service;

import com.empresa.motoboy.dto.LoginRequestDTO;
import com.empresa.motoboy.dto.LoginResponseDTO;
import com.empresa.motoboy.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponseDTO login(LoginRequestDTO dto) {

        var authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                dto.email(),
                                dto.senha()
                        )
                );

        Usuario usuario =
                (Usuario) authentication.getPrincipal();

        String token =
                jwtService.gerarToken(usuario);

        return new LoginResponseDTO(token);
    }
}