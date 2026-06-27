package com.empresa.motoboy.dto;

import com.empresa.motoboy.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(

        @NotBlank
        String nome,

        @Email
        String email,

        @Size(min = 6)
        String senha

) {}