package com.empresa.motoboy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LojaRequestDTO {

    @NotBlank
    @Schema(description = "Nome da loja", example = "Tropical Sushi Olegario")
    private String nome;

    @NotBlank
    @Schema(description = "Endereço da loja",
            example = "Condomínio Luna Barra Center - Av. Olegário Maciel, 101")
    private String endereco;

    @NotNull
    @Schema(description = "Valor da diária", example = "70")
    private BigDecimal valorDiaria;

}