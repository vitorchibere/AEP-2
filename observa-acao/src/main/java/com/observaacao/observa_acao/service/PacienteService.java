package com.observaacao.observa_acao.service;

import com.observaacao.observa_acao.model.Paciente;
import com.observaacao.observa_acao.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Paciente buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
