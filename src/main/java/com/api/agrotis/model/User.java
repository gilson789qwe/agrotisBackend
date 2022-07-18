package com.api.agrotis.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@SequenceGenerator(name = "seq_user", sequenceName =  "seq_user", allocationSize = 1, initialValue = 1)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "seq_user")
    private Long    id;

    private String  nome;
    private Date    dataInicial;
    private Date    dataFinal;

    @Column(columnDefinition="TEXT")
    private String  infosPropriedade;

    private String  cnpj;

    @Column(columnDefinition="TEXT")
    private String  laboratorio;

    private String  observacoes;

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getInfosPropriedade() {
        return infosPropriedade;
    }

    public void setInfosPropriedade(String infosPropriedade) {
        this.infosPropriedade = infosPropriedade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
