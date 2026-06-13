package com.observaacao.observa_acao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "unidades_saude")
public class UnidadeSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public UnidadeSaude() {
    }

    public UnidadeSaude(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
