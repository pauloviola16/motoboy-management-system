package com.empresa.motoboy.service;

import com.empresa.motoboy.dto.EscalaRequestDTO;
import com.empresa.motoboy.dto.EscalaResponseDTO;
import com.empresa.motoboy.dto.LojaDashboardDTO;
import com.empresa.motoboy.exception.BusinessException;
import com.empresa.motoboy.exception.ResourceNotFoundException;
import com.empresa.motoboy.model.Escala;
import com.empresa.motoboy.model.Loja;
import com.empresa.motoboy.model.Motoboy;
import com.empresa.motoboy.model.StatusEscala;
import com.empresa.motoboy.model.StatusMotoboy;
import com.empresa.motoboy.repository.EscalaRepository;
import com.empresa.motoboy.repository.LojaRepository;
import com.empresa.motoboy.repository.MotoboyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EscalaService {

    private final EscalaRepository escalaRepository;
    private final MotoboyRepository motoboyRepository;
    private final LojaRepository lojaRepository;

    public Escala criar(EscalaRequestDTO dto) {

        Motoboy motoboy = motoboyRepository.findById(dto.getMotoboyId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Motoboy não encontrado"));

        Loja loja = lojaRepository.findById(dto.getLojaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Loja não encontrada"));

        if (motoboy.getStatus() == StatusMotoboy.INATIVO) {

            throw new BusinessException(
                    "Motoboy inativo não pode receber escala"
            );
        }

        Escala escala = new Escala();

        escala.setMotoboy(motoboy);
        escala.setLoja(loja);
        escala.setData(dto.getData());
        escala.setHorarioInicio(dto.getHorarioInicio());
        escala.setHorarioFim(dto.getHorarioFim());

        return escalaRepository.save(escala);
    }

    public void cancelarEscala(Long id) {

        Escala escala = escalaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Escala não encontrada"));

        escala.setStatus(StatusEscala.CANCELADA);

        escalaRepository.save(escala);
    }

    public List<LojaDashboardDTO> buscarDashboard(LocalDate data) {

        List<Loja> lojas = lojaRepository.findAll();

        List<LojaDashboardDTO> dashboard = new ArrayList<>();

        for (Loja loja : lojas) {

            List<Escala> escalas =
                    escalaRepository.findByLojaIdAndData(
                            loja.getId(),
                            data
                    );

            List<EscalaResponseDTO> escalasDTO = escalas.stream()
                    .map(escala -> new EscalaResponseDTO(
                            escala.getId(),
                            escala.getMotoboy().getNome(),
                            escala.getHorarioInicio(),
                            escala.getHorarioFim(),
                            escala.getStatus()
                    ))
                    .toList();

            LojaDashboardDTO lojaDTO =
                    new LojaDashboardDTO(
                            loja.getId(),
                            loja.getNome(),
                            escalasDTO
                    );

            dashboard.add(lojaDTO);
        }

        return dashboard;
    }
}
