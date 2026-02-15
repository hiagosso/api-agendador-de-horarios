package com.hiago.agendadorhorarios.services;

import com.hiago.agendadorhorarios.infrastructure.entity.Agendamento;
import com.hiago.agendadorhorarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public Agendamento salvarAgendamento(Agendamento agendamento){

        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);

        Agendamento agendados = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween(
                agendamento.getServico(),
                horaAgendamento,
                horaFim
        );

        if (Objects.nonNull(agendados)){
            throw new RuntimeException("não ha horário disponivel");
        }

        return  agendamentoRepository.save(agendamento);

    }

    public void deletarAgendamento(LocalDateTime dataHoraAgendada, String cliente){

        Agendamento agendamento = agendamentoRepository
                .findByDataHoraAgendamentoAndCliente(dataHoraAgendada,cliente);

        if (Objects.nonNull(agendamento)){
            agendamentoRepository.delete(agendamento);
        }else {
            throw new RuntimeException("este agendamento não existe");
        }
    }

    public List<Agendamento> buscarAgendamentosDoDia(LocalDate data){

        if (Objects.isNull(data)){
            return agendamentoRepository.findAll();
        }

        LocalDateTime inicio = data.atStartOfDay();
        LocalDateTime fim = data.plusDays(1).atStartOfDay();


        return agendamentoRepository.findByDataHoraAgendamentoGreaterThanEqualAndDataHoraAgendamentoLessThan(
                inicio,fim
        );
    }

    public Agendamento alterarAgendamento(String cliente, Agendamento agendamento, LocalDateTime dataHoraAgendada){
        Agendamento agendado = agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendada,cliente);

        if (Objects.isNull(agendado)){
            throw new RuntimeException("agendamento não encontrado");
        }

        agendamento.setId(agendado.getId());
        return agendamentoRepository.save(agendamento);

    }
}
