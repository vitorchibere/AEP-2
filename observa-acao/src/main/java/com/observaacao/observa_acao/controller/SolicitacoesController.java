package com.observaacao.observa_acao.controller;

import com.observaacao.observa_acao.model.Solicitacoes;
import com.observaacao.observa_acao.service.SolicitacoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SolicitacoesController {

    private final SolicitacoesService solicitacoesService;

    public SolicitacoesController(SolicitacoesService solicitacoesService) {
        this.solicitacoesService = solicitacoesService;
    }

    @GetMapping("/acompanhamento")
    public String acompanhamento() {
        return "acompanhamento";
    }

    @PostMapping("/acompanhamento")
    public String consultarSolicitacao(@RequestParam String cpf,
                                       @RequestParam Long protocolo,
                                       Model model) {

        Solicitacoes solicitacao = solicitacoesService.buscarPorProtocolo(protocolo);

        if (solicitacao != null &&
                solicitacao.getPaciente() != null &&
                solicitacao.getPaciente().getCpf().equals(cpf)) {

            model.addAttribute("solicitacao", solicitacao);
        } else {
            model.addAttribute("erro", "Solicitação não encontrada para os dados informados.");
        }

        return "acompanhamento";
    }
}