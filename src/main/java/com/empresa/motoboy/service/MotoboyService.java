package com.empresa.motoboy.service;

import com.empresa.motoboy.model.Motoboy;
import com.empresa.motoboy.repository.MotoboyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotoboyService {

    private final MotoboyRepository motoboyRepository;

    public Motoboy criar(Motoboy motoboy) {
        return motoboyRepository.save(motoboy);
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
