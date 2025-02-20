package com.agendamento.notificacao_api.business;

import com.agendamento.notificacao_api.business.mapper.IAgendamentoMapper;
import com.agendamento.notificacao_api.controller.dto.in.AgendamentoRecord;
import com.agendamento.notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.agendamento.notificacao_api.infraestructure.entities.Agendamento;
import com.agendamento.notificacao_api.infraestructure.enums.StatusNotificacaoEnum;
import com.agendamento.notificacao_api.infraestructure.repositories.AgendamentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class AgendamentoServiceTest {

    @InjectMocks
    private AgendamentoService agendamentoService;

    @Mock
    private AgendamentoRepository repository;

    @Mock
    private IAgendamentoMapper agendamentoMapper;

    private AgendamentoRecord agendamentoRecord;
    private AgendamentoRecordOut agendamentoRecordOut;
    private Agendamento agendamentoEntity;

    @BeforeEach
    void setUp() {

        agendamentoRecord = new AgendamentoRecord(
                "email@email.com",
                "55887996578",
                "Favor retornar a loja com urgência",
                LocalDateTime.of(2025, 1, 2, 11, 1, 1)
        );

        agendamentoEntity = Agendamento.builder()
                 .id(1L)
                .dataHoraEnvio(LocalDateTime.of(2025, 01, 02, 11, 01, 01))
                .emailDestinatario("email@email.com")
                .telefonedestinatario("987865643")
                .mensagem("Favor retornar a loja com urgência")
                .dataHoraAgendamento(LocalDateTime.now())
                .build();

        // Resultado esperado
        agendamentoRecordOut = new AgendamentoRecordOut(
                1L,
                "email@email.com",
                "55887996578",
                "Favor retornar a loja com urgência",
                LocalDateTime.of(2025, 1, 2, 11, 1, 1),
                StatusNotificacaoEnum.AGENDADO
        );
    }

    @Test
    void deveGravarAgendamentoComSucesso() {
        when(agendamentoMapper.paraEntity(agendamentoRecord)).thenReturn(agendamentoEntity);
        when(repository.save(agendamentoEntity)).thenReturn(agendamentoEntity);
        when(agendamentoMapper.paraOut(agendamentoEntity)).thenReturn(agendamentoRecordOut);

        AgendamentoRecordOut out = agendamentoService.gravarAgendamento(agendamentoRecord);

        verify(agendamentoMapper, times(1)).paraEntity(agendamentoRecord);
        verify(repository, times(1)).save(agendamentoEntity);
        verify(agendamentoMapper, times(1)).paraOut(agendamentoEntity);
        assertThat(out).usingRecursiveComparison().isEqualTo(agendamentoRecordOut);
    }
}
