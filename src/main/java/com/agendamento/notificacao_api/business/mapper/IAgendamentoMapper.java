package com.agendamento.notificacao_api.business.mapper;

import com.agendamento.notificacao_api.controller.dto.in.AgendamentoRecord;
import com.agendamento.notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.agendamento.notificacao_api.infraestructure.entities.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecord agendamento);
    AgendamentoRecordOut paraOut(Agendamento agendamento);

    @Mapping(target = "dataHoraModificacao", expression = "java(LocalDateTime.now()")
    @Mapping(target = "statusNotificacao", expression = "java(StatusNotificacaoEnum.CANCELADO)")
    Agendamento paraEntityCancelamento(Agendamento agendamento);
}
