package com.observaacao.observa_acao.service;

import com.observaacao.observa_acao.model.UnidadeSaude;
import com.observaacao.observa_acao.repository.UnidadeSaudeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeSaudeService {

    private final UnidadeSaudeRepository repository;

    public UnidadeSaudeService(UnidadeSaudeRepository repository) {
        this.repository = repository;
    }

    public UnidadeSaude salvar(UnidadeSaude unidadeSaude) {
        return repository.save(unidadeSaude);
    }

    public List<UnidadeSaude> listarTodas() {
        return repository.findAll();
    }

    public UnidadeSaude buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
