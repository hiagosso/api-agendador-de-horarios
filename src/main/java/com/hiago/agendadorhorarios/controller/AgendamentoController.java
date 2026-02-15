package com.hiago.agendadorhorarios.controller;

import com.hiago.agendadorhorarios.infrastructure.entity.Agendamento;
import com.hiago.agendadorhorarios.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento){
        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
    }
    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento
            (@RequestParam String cliente,
             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dataHoraAgendamento){
        agendamentoService.deletarAgendamento(dataHoraAgendamento,cliente);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<Agendamento>> buscarAgendamentosDia(
            @RequestParam(required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dia){
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDoDia(dia));
    }

    @PutMapping
    public ResponseEntity<Agendamento> alterarAgendamento(
            @RequestBody Agendamento agendamento,
            @RequestParam String cliente,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dataHoraAgendamento){
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(cliente,agendamento,dataHoraAgendamento));
    }
}
