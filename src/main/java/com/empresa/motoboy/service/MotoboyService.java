package com.empresa.motoboy.service;

import com.empresa.motoboy.dto.MotoboyRequestDTO;
import com.empresa.motoboy.dto.MotoboyResponseDTO;
import com.empresa.motoboy.model.Motoboy;
import com.empresa.motoboy.repository.MotoboyRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotoboyService {

    private final MotoboyRepository motoboyRepository;

    public MotoboyResponseDTO criar(@Valid @RequestBody MotoboyRequestDTO dto) {

        Motoboy motoboy = new Motoboy();

        motoboy.setNome(dto.getNome());
        motoboy.setTelefone(dto.getTelefone());

        Motoboy motoboySalvo = motoboyRepository.save(motoboy);

        return new MotoboyResponseDTO(
                motoboySalvo.getId(),
                motoboySalvo.getNome(),
                motoboySalvo.getTelefone(),
                motoboySalvo.getStatus(),
                motoboySalvo.getDataCadastro()
        );
    }

    public List<Motoboy> listar() {
        return motoboyRepository.findAll();
    }

    public Motoboy buscarPorId(Long id) {
        return motoboyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motoboy não encontrado"));
    }

    public Motoboy atualizar(Long id, Motoboy motoboyAtualizado) {

        Motoboy motoboy = buscarPorId(id);

        motoboy.setNome(motoboyAtualizado.getNome());
        motoboy.setTelefone(motoboyAtualizado.getTelefone());
        motoboy.setStatus(motoboyAtualizado.getStatus());

        return motoboyRepository.save(motoboy);
    }

    public void deletar(Long id) {

        Motoboy motoboy = buscarPorId(id);

        motoboyRepository.delete(motoboy);
    }
}
