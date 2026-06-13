package com.observaacao.observa_acao;

import com.observaacao.observa_acao.model.Medico;
import com.observaacao.observa_acao.model.UnidadeSaude;
import com.observaacao.observa_acao.service.MedicoService;
import com.observaacao.observa_acao.service.UnidadeSaudeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final MedicoService medicoService;
    private final UnidadeSaudeService unidadeSaudeService;

    public DataLoader(MedicoService medicoService,
                      UnidadeSaudeService unidadeSaudeService) {
        this.medicoService = medicoService;
        this.unidadeSaudeService = unidadeSaudeService;
    }

    @Override
    public void run(String... args) {

        if (unidadeSaudeService.listarTodas().isEmpty()) {
            unidadeSaudeService.salvar(new UnidadeSaude("UBS Zona Norte"));
            unidadeSaudeService.salvar(new UnidadeSaude("UPA Central"));
            unidadeSaudeService.salvar(new UnidadeSaude("Hospital Municipal"));
        }

        if (medicoService.listarTodos().isEmpty()) {
            medicoService.salvar(new Medico("Dr. João", "Clínico Geral"));
            medicoService.salvar(new Medico("Dra. Maria", "Pediatria"));
            medicoService.salvar(new Medico("Dr. Carlos", "Ortopedia"));
            medicoService.salvar(new Medico("Dra. Fernanda", "Enfermagem"));
        }
    }
}
