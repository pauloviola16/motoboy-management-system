package com.empresa.motoboy.model;

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
public class Escala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "motoboy_id", nullable = false)
    private Motoboy motoboy;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "loja_id", nullable = false)
    private Loja loja;

    @NotNull
    @Column(nullable = false)
    private LocalDate data;

    @NotNull
    @Column(nullable = false)
    private LocalTime horarioInicio;

    @NotNull
    @Column(nullable = false)
    private LocalTime horarioFim;

    @Column(length = 255)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario criadoPor;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {

        this.dataCriacao = LocalDateTime.now();

        }
    }

