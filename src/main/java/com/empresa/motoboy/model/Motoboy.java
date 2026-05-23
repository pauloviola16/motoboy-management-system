package com.empresa.motoboy.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "motoboys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Entidade responsável pelos motoboys")
public class Motoboy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do motoboy", example = "1")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    @Schema(description = "Nome do motoboy", example = "Carlos Silva")
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true, length = 20)
    @Schema(description = "Telefone do motoboy", example = "(21) 98888-7777")
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "Status do motoboy", example = "ATIVO")
    private StatusMotoboy status;

    @Column(nullable = false, updatable = false)
    @Schema(description = "Data de cadastro do motoboy")
    private LocalDateTime dataCadastro;

    @PrePersist
    public void prePersist() {

        this.dataCadastro = LocalDateTime.now();

        if (this.status == null) {
            this.status = StatusMotoboy.ATIVO;
        }
    }
}
