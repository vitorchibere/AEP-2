package com.observaacao.observa_acao.model;

import com.observaacao.observa_acao.enums.AcompanhamentoDeStatus;
import com.observaacao.observa_acao.enums.Categoria;
import jakarta.persistence.*;

@Entity
@Table(name = "solicitacoes")
public class Solicitacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long protocolo;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private UnidadeSaude unidadeSaude;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Integer nota;

    @Column(length = 1000)
    private String comentario;

    @Enumerated(EnumType.STRING)
    private AcompanhamentoDeStatus status;

    public Solicitacoes() {
        this.status = AcompanhamentoDeStatus.REGISTRADO;
    }

    public Long getProtocolo() {
        return protocolo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public UnidadeSaude getUnidadeSaude() {
        return unidadeSaude;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Integer getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public AcompanhamentoDeStatus getStatus() {
        return status;
    }

    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
        this.unidadeSaude = unidadeSaude;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNota(Integer nota) {

        if (nota < 0 || nota > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 5.");
        }

        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setStatus(AcompanhamentoDeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Solicitacoes{" +
                "protocolo=" + protocolo +
                ", categoria=" + categoria +
                ", nota=" + nota +
                ", status=" + status +
                '}';
    }
}