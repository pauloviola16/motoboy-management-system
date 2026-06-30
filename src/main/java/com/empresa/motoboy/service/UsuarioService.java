package com.empresa.motoboy.service;

import com.empresa.motoboy.dto.UsuarioRequestDTO;
import com.empresa.motoboy.model.Role;
import com.empresa.motoboy.model.Usuario;
import com.empresa.motoboy.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario cadastrar(UsuarioRequestDTO dto) {

        if (usuarioRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email já cadastrado.");
        }

        Usuario usuario = Usuario.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(passwordEncoder.encode(dto.senha()))
                .role(Role.USER)
                .build();

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado."));
    }

    public Usuario atualizar(Long id, UsuarioRequestDTO dto) {

        Usuario usuario = buscarPorId(id);

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());

        if (dto.senha() != null && !dto.senha().isBlank()) {
            usuario.setSenha(
                    passwordEncoder.encode(dto.senha())
            );
        }

        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {

        Usuario usuario = buscarPorId(id);

        usuarioRepository.delete(usuario);
    }

    public Usuario promoverParaAdmin(Long id) {

        Usuario usuario = buscarPorId(id);

        usuario.setRole(Role.ADMIN);

        return usuarioRepository.save(usuario);
    }
}