package com.empresa.motoboy.service;

import com.empresa.motoboy.dto.LojaRequestDTO;
import com.empresa.motoboy.dto.LojaResponseDTO;
import com.empresa.motoboy.model.Loja;
import com.empresa.motoboy.repository.LojaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LojaService {

    private final LojaRepository lojaRepository;

    public LojaResponseDTO criar(LojaRequestDTO dto) {

        Loja loja = new Loja();

        loja.setNome(dto.getNome());
        loja.setEndereco(dto.getEndereco());
        loja.setValorDiaria(dto.getValorDiaria());

        Loja lojaSalva = lojaRepository.save(loja);

        return new LojaResponseDTO(
                lojaSalva.getId(),
                lojaSalva.getNome(),
                lojaSalva.getEndereco(),
                lojaSalva.getValorDiaria()
        );
    }

    public List<Loja> listar() {
        return lojaRepository.findAll();
    }

    public Loja buscarPorId(Long id) {
        return lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));
    }

    public LojaResponseDTO atualizar(Long id, LojaRequestDTO dto) {

        Loja loja = buscarPorId(id);

        loja.setNome(dto.getNome());
        loja.setEndereco(dto.getEndereco());
        loja.setValorDiaria(dto.getValorDiaria());

        Loja lojaAtualizada = lojaRepository.save(loja);

        return new LojaResponseDTO(
                lojaAtualizada.getId(),
                lojaAtualizada.getNome(),
                lojaAtualizada.getEndereco(),
                lojaAtualizada.getValorDiaria()
        );
    }

    public void deletar(Long id) {

        Loja loja = buscarPorId(id);

        lojaRepository.delete(loja);
    }
}