package com.empresa.motoboy.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Entidade responsável pelos usuários do sistema")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do usuário", example = "1")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false)
    @Schema(description = "Nome do usuário", example = "Paulo Viola")
    private String nome;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    @Schema(description = "Email do usuário", example = "paulo@email.com")
    private String email;

    @NotBlank
    @Size(min = 6)
    @Column(nullable = false)
    @Schema(description = "Senha do usuário", example = "123456")
    private String senha;

    @Column(nullable = false, updatable = false)
    @Schema(description = "Data de cadastro do usuário")
    private LocalDateTime dataCadastro;

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now();
    }
}
