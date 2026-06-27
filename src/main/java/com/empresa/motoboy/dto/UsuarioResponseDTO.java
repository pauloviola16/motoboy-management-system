package com.empresa.motoboy.dto;

import com.empresa.motoboy.model.Role;

public record UsuarioResponseDTO(

        Long id,
        String nome,
        String email,
        Role role

) {}