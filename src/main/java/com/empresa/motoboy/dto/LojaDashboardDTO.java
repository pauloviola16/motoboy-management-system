package com.empresa.motoboy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LojaDashboardDTO {

    private Long lojaId;

    private String nomeLoja;

    private List<EscalaResponseDTO> escalas;
}