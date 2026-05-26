package com.empresa.motoboy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EscalaDashboardDTO {

    private Long escalaId;

    private String nomeMotoboy;

    private LocalTime horarioInicio;

    private LocalTime horarioFim;
}