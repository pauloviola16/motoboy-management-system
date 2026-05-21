package com.empresa.motoboy.dto;

import com.empresa.motoboy.model.StatusEscala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class EscalaResponseDTO {

    private Long escalaId;

    private String nomeMotoboy;

    private LocalTime horarioInicio;

    private LocalTime horarioFim;

    private StatusEscala status;
}