package com.agendamento.notificacao_api.controller;

import com.agendamento.notificacao_api.business.AgendamentoService;
import com.agendamento.notificacao_api.controller.dto.in.AgendamentoRecord;
import com.agendamento.notificacao_api.controller.dto.out.AgendamentoRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;
    @PostMapping
    public ResponseEntity<AgendamentoRecordOut> gravarAgendamentos(@RequestBody AgendamentoRecord agendamentoRecord) {
        return ResponseEntity.ok(agendamentoService.gravarAgendamento(agendamentoRecord));
    }

    @GetMapping("/id")
    public ResponseEntity<AgendamentoRecordOut> buscarAgendamentoPorId(@PathVariable("id")Long id){
        return ResponseEntity.ok(agendamentoService.buscarAgendamentosPorId(id));
    }

}
