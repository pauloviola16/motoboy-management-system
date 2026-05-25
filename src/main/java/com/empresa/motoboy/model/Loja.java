package com.empresa.motoboy.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "lojas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Entidade responsável pelas lojas")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da loja", example = "1")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false)
    @Schema(description = "Nome da loja", example = "McDonald's Copacabana")
    private String nome;

    @Size(max = 150)
    @Column(length = 150)
    @Schema(description = "Endereço da loja", example = "Av. Atlântica, 500")
    private String endereco;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    @Schema(description = "Valor da diária paga ao motoboy", example = "70.00")
    private BigDecimal valorDiaria;
}