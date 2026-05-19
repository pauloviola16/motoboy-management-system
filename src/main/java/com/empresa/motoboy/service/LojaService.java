package com.empresa.motoboy.service;

import com.empresa.motoboy.model.Loja;
import com.empresa.motoboy.repository.LojaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LojaService {

    private final LojaRepository lojaRepository;

    public Loja criar(Loja loja) {
        return lojaRepository.save(loja);
    }

    public List<Loja> listar() {
        return lojaRepository.findAll();
    }

    public Loja buscarPorId(Long id) {
        return lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));
    }

    public Loja atualizar(Long id, Loja lojaAtualizada) {

        Loja loja = buscarPorId(id);

        loja.setNome(lojaAtualizada.getNome());
        loja.setEndereco(lojaAtualizada.getEndereco());
        loja.setTelefone(lojaAtualizada.getTelefone());

        return lojaRepository.save(loja);
    }

    public void deletar(Long id) {

        Loja loja = buscarPorId(id);

        lojaRepository.delete(loja);
    }
}