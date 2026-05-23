package com.empresa.motoboy.dto;

import com.empresa.motoboy.model.StatusEscala;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "DTO de resposta das escalas")
public class EscalaResponseDTO {

    @Schema(description = "ID da escala", example = "1")
    private Long escalaId;

    @Schema(description = "Nome do motoboy", example = "Carlos Silva")
    private String nomeMotoboy;

    @Schema(description = "Horário de início", example = "08:00")
    private LocalTime horarioInicio;

    @Schema(description = "Horário de fim", example = "18:00")
    private LocalTime horarioFim;

    @Schema(description = "Status da escala", example = "CONFIRMADA")
    private StatusEscala status;
}