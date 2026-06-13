package com.observaacao.observa_acao.enums;

public enum Categoria {

    MEDICO("Médicos"),
    ENFERMAGEM("Enfermagem"),
    INFRAESTRUTURA("Infraestrutura");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}