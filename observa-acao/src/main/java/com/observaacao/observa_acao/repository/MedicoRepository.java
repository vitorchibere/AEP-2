package com.observaacao.observa_acao.repository;

import com.observaacao.observa_acao.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}