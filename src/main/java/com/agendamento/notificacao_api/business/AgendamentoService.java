package com.agendamento.notificacao_api.business;

import com.agendamento.notificacao_api.business.mapper.IAgendamentoMapper;
import com.agendamento.notificacao_api.controller.dto.in.AgendamentoRecord;
import com.agendamento.notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.agendamento.notificacao_api.infraestructure.entities.Agendamento;
import com.agendamento.notificacao_api.infraestructure.exceptions.NotFoundException;
import com.agendamento.notificacao_api.infraestructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento){
       return agendamentoMapper.paraOut(
               repository.save(agendamentoMapper.paraEntity(agendamento)));

    }

    public AgendamentoRecordOut buscarAgendamentosPorId(Long id){
        return agendamentoMapper.paraOut(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado")));
    }

    public void cancelarAgendamento(Long id) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado"));
        repository.save(agendamentoMapper.paraEntityCancelamento(agendamento));
    }

}
