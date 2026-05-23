package com.empresa.motoboy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Schema(description = "DTO para criação de escalas")
public class EscalaRequestDTO {

    @NotNull
    @Schema(description = "ID do motoboy", example = "1")
    private Long motoboyId;

    @NotNull
    @Schema(description = "ID da loja", example = "2")
    private Long lojaId;

    @NotNull
    @Schema(description = "Data da escala", example = "2026-05-23")
    private LocalDate data;

    @NotNull
    @Schema(description = "Horário de início da escala", example = "08:00")
    private LocalTime horarioInicio;

    @NotNull
    @Schema(description = "Horário de fim da escala", example = "18:00")
    private LocalTime horarioFim;
}
