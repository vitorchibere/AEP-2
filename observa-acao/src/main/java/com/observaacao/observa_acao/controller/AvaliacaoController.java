package com.observaacao.observa_acao.controller;

import com.observaacao.observa_acao.enums.AcompanhamentoDeStatus;
import com.observaacao.observa_acao.enums.Categoria;
import com.observaacao.observa_acao.model.Medico;
import com.observaacao.observa_acao.model.Paciente;
import com.observaacao.observa_acao.model.Solicitacoes;
import com.observaacao.observa_acao.model.UnidadeSaude;
import com.observaacao.observa_acao.service.MedicoService;
import com.observaacao.observa_acao.service.PacienteService;
import com.observaacao.observa_acao.service.SolicitacoesService;
import com.observaacao.observa_acao.service.UnidadeSaudeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AvaliacaoController {

    private final PacienteService pacienteService;
    private final MedicoService medicoService;
    private final UnidadeSaudeService unidadeSaudeService;
    private final SolicitacoesService solicitacoesService;

    public AvaliacaoController(PacienteService pacienteService,
                               MedicoService medicoService,
                               UnidadeSaudeService unidadeSaudeService,
                               SolicitacoesService solicitacoesService) {
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
        this.unidadeSaudeService = unidadeSaudeService;
        this.solicitacoesService = solicitacoesService;
    }

    @GetMapping("/avaliacao/paciente")
    public String identificacaoPaciente() {
        return "identificacao";
    }

    @PostMapping("/avaliacao/paciente")
    public String salvarPaciente(@RequestParam String nome,
                                 @RequestParam String cpf,
                                 HttpSession session) {

        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setCpf(cpf);

        Paciente pacienteSalvo = pacienteService.salvar(paciente);
        session.setAttribute("pacienteId", pacienteSalvo.getId());

        return "redirect:/avaliacao/unidade";
    }

    @GetMapping("/avaliacao/unidade")
    public String unidade(Model model) {
        model.addAttribute("unidades", unidadeSaudeService.listarTodas());
        return "unidade";
    }

    @PostMapping("/avaliacao/unidade")
    public String salvarUnidade(@RequestParam Long unidadeId,
                                HttpSession session) {

        session.setAttribute("unidadeId", unidadeId);
        return "redirect:/avaliacao/categoria";
    }

    @GetMapping("/avaliacao/categoria")
    public String categoria() {
        return "categoria";
    }

    @PostMapping("/avaliacao/categoria")
    public String salvarCategoria(@RequestParam Categoria categoria,
                                  HttpSession session) {

        session.setAttribute("categoria", categoria);

        if (categoria == Categoria.INFRAESTRUTURA) {
            session.removeAttribute("medicoId");
            return "redirect:/avaliacao/formulario";
        }

        return "redirect:/avaliacao/profissional";
    }

    @GetMapping("/avaliacao/profissional")
    public String profissional(Model model) {
        model.addAttribute("medicos", medicoService.listarTodos());
        return "profissional";
    }

    @PostMapping("/avaliacao/profissional")
    public String salvarProfissional(@RequestParam Long medicoId,
                                     HttpSession session) {

        session.setAttribute("medicoId", medicoId);
        return "redirect:/avaliacao/formulario";
    }

    @GetMapping("/avaliacao/formulario")
    public String formulario() {
        return "avaliacao";
    }

    @PostMapping("/avaliacao/formulario")
    public String salvarAvaliacao(@RequestParam Integer nota,
                                  @RequestParam String comentario,
                                  HttpSession session,
                                  Model model) {

        Long pacienteId = (Long) session.getAttribute("pacienteId");
        Long unidadeId = (Long) session.getAttribute("unidadeId");
        Long medicoId = (Long) session.getAttribute("medicoId");
        Categoria categoria = (Categoria) session.getAttribute("categoria");

        Paciente paciente = pacienteService.buscarPorId(pacienteId);
        UnidadeSaude unidade = unidadeSaudeService.buscarPorId(unidadeId);

        Solicitacoes solicitacao = new Solicitacoes();
        solicitacao.setPaciente(paciente);
        solicitacao.setUnidadeSaude(unidade);
        solicitacao.setCategoria(categoria);
        solicitacao.setNota(nota);
        solicitacao.setComentario(comentario);
        solicitacao.setStatus(AcompanhamentoDeStatus.REGISTRADO);

        if (categoria != Categoria.INFRAESTRUTURA && medicoId != null) {
            Medico medico = medicoService.buscarPorId(medicoId);
            solicitacao.setMedico(medico);
        }

        Solicitacoes salva = solicitacoesService.salvar(solicitacao);

        session.removeAttribute("pacienteId");
        session.removeAttribute("unidadeId");
        session.removeAttribute("medicoId");
        session.removeAttribute("categoria");

        model.addAttribute("protocolo", salva.getProtocolo());

        return "sucesso";
    }
}