package com.empresa.motoboy.repository;

import com.empresa.motoboy.model.Usuario;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(@Email String email);
}

