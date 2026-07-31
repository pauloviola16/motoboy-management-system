package com.empresa.motoboy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "escalas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Entidade responsável pelas escalas dos motoboys")
public class Escala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da escala", example = "1")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "Status da escala", example = "CONFIRMADA")
    private StatusEscala status = StatusEscala.NAO_CONFIRMADA;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "motoboy_id", nullable = false)
    @JsonIgnore
    @Schema(description = "Motoboy vinculado à escala")
    private Motoboy motoboy;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "loja_id", nullable = false)
    @JsonIgnore
    @Schema(description = "Loja vinculada à escala")
    private Loja loja;

    @NotNull
    @Column(nullable = false)
    @Schema(description = "Data da escala", example = "2026-05-23")
    private LocalDate data;

    @NotNull
    @Column(nullable = false)
    @Schema(description = "Horário de início", example = "08:00")
    private LocalTime horarioInicio;

    @NotNull
    @Column(nullable = false)
    @Schema(description = "Horário de fim", example = "18:00")
    private LocalTime horarioFim;

    @Column(nullable = false, updatable = false)
    @Schema(description = "Data de criação da escala")
    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {

        this.dataCriacao = LocalDateTime.now();

        if (this.status == null) {
            this.status = StatusEscala.CONFIRMADA;
        }
    }
}

