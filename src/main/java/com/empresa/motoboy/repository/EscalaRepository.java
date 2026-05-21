package com.empresa.motoboy.repository;

import com.empresa.motoboy.model.Escala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EscalaRepository extends JpaRepository<Escala, Long> {

    List<Escala> findByData(LocalDate data);

    List<Escala> findByLojaId(Long lojaId);

    List<Escala> findByLojaIdAndData(Long lojaId, LocalDate data);
}