package com.agendamento.notificacao_api.infraestructure.repositories;

import com.agendamento.notificacao_api.infraestructure.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
