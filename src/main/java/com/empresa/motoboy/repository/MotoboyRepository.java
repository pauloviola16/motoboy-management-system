package com.empresa.motoboy.repository;

import com.empresa.motoboy.model.Motoboy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotoboyRepository extends JpaRepository<Motoboy, Long> {

    Optional<Motoboy> findByTelefone (String telefone);
}
