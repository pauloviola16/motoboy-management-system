package com.empresa.motoboy.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

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

    @NotBlank
    @Column(nullable = false, unique = true, length = 20)
    @Schema(description = "Telefone da loja", example = "(21) 99999-9999")
    private String telefone;
}