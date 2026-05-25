package com.empresa.motoboy.dto;

import com.empresa.motoboy.model.StatusMotoboy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MotoboyResponseDTO {

    private Long id;
    private String nome;
    private String telefone;
    private StatusMotoboy status;
    private LocalDateTime dataCadastro;
}
