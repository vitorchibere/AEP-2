package com.observaacao.observa_acao.enums;

public enum AcompanhamentoDeStatus {

    REGISTRADO("Registrado"),
    EM_ANALISE("Em análise"),
    FINALIZADO("Finalizado");

    private final String descricao;

    AcompanhamentoDeStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
