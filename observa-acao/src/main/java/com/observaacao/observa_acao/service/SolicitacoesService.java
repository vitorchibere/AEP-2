package com.observaacao.observa_acao.service;

import com.observaacao.observa_acao.enums.AcompanhamentoDeStatus;
import com.observaacao.observa_acao.model.Solicitacoes;
import com.observaacao.observa_acao.repository.SolicitacoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitacoesService {

    private final SolicitacoesRepository repository;

    public SolicitacoesService(
            SolicitacoesRepository repository) {

        this.repository = repository;
    }

    public Solicitacoes salvar(
            Solicitacoes solicitacao) {

        return repository.save(solicitacao);
    }

    public List<Solicitacoes> listarTodas() {
        return repository.findAll();
    }

    public Solicitacoes buscarPorProtocolo(
            Long protocolo) {

        return repository.findById(protocolo)
                .orElse(null);
    }

    public void atualizarStatus(
            Long protocolo,
            AcompanhamentoDeStatus status) {

        Solicitacoes solicitacao =
                buscarPorProtocolo(protocolo);

        if (solicitacao != null) {

            solicitacao.setStatus(status);

            repository.save(solicitacao);
        }
    }
}