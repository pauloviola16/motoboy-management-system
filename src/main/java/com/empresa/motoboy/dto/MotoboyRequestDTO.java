package com.empresa.motoboy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MotoboyRequestDTO {

    @NotBlank
    @Schema(description = "Nome do motoboy", example = "Carlos Silva")
    private String nome;

    @NotBlank
    @Schema(description = "Telefone do motoboy", example = "(21) 98888-7777")
    private String telefone;
}