package com.empresa.motoboy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class LojaResponseDTO {

    private Long id;
    private String nome;
    private String endereco;
    private BigDecimal valorDiaria;
}
