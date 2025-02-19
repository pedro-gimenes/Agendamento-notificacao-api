package com.agendamento.notificacao_api.controller.dto.out;

import com.agendamento.notificacao_api.infraestructure.enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AgendamentoRecordOut(Long id, String emailDestinatario,
                                   String telefoneDestinatario, String mensagem,
                                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                   LocalDateTime dataHoraEnvio, StatusNotificacaoEnum statusNotificacao) {
}
