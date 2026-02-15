package com.hiago.agendadorhorarios.infrastructure.repository;

import com.hiago.agendadorhorarios.infrastructure.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Agendamento findByServicoAndDataHoraAgendamentoBetween(
            String servico,
            LocalDateTime dataHoraInicio,
            LocalDateTime dataHoraFinal
    );

    Agendamento findByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendada, String cliente);

    List<Agendamento> findByDataHoraAgendamentoGreaterThanEqualAndDataHoraAgendamentoLessThan(
            LocalDateTime dataHoraInicio,
            LocalDateTime dataHoraFinal
    );
}
