package com.observaacao.observa_acao.service;

import com.observaacao.observa_acao.model.Medico;
import com.observaacao.observa_acao.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public Medico salvar(Medico medico) {
        return repository.save(medico);
    }

    public List<Medico> listarTodos() {
        return repository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
