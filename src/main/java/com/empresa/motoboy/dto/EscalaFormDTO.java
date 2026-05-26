package com.empresa.motoboy.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class EscalaFormDTO {

    @NotNull
    private Long motoboyId;

    @NotNull
    private Long lojaId;

    @NotNull
    private LocalDate data;

    @NotNull
    private LocalTime horarioInicio;

    @NotNull
    private LocalTime horarioFim;
}
