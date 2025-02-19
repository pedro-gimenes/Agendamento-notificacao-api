package com.agendamento.notificacao_api.business;

import com.agendamento.notificacao_api.business.mapper.IAgendamentoMapper;
import com.agendamento.notificacao_api.controller.dto.in.AgendamentoRecord;
import com.agendamento.notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.agendamento.notificacao_api.infraestructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento){
        agendamentoMapper.paraEntity(agendamento);
       return agendamentoMapper.paraOut(repository.save(agendamentoMapper.paraEntity(agendamento)));

    }

}
