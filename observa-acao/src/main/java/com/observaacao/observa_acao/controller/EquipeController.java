package com.observaacao.observa_acao.controller;

import com.observaacao.observa_acao.enums.AcompanhamentoDeStatus;
import com.observaacao.observa_acao.service.SolicitacoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EquipeController {

    private final SolicitacoesService solicitacoesService;

    public EquipeController(SolicitacoesService solicitacoesService) {
        this.solicitacoesService = solicitacoesService;
    }

    @GetMapping("/equipe/login")
    public String login() {
        return "login";
    }

    @GetMapping("/equipe/painel")
    public String painel(Model model) {

        model.addAttribute(
                "solicitacoes",
                solicitacoesService.listarTodas()
        );

        return "painel";
    }

    @PostMapping("/equipe/status")
    public String atualizarStatus(
            @RequestParam Long protocolo,
            @RequestParam AcompanhamentoDeStatus status) {

        solicitacoesService.atualizarStatus(
                protocolo,
                status
        );

        return "redirect:/equipe/painel";
    }
}