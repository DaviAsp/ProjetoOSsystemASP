package com.example.projetoossystemasp.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import java.util.Calendar;

public class OrdemServico implements Serializable {

    private int nrOS;
    private  String marca, modelo, nrserie, defeito, solucao;
    private String datacriacao, dataconclusao;

    public OrdemServico(int nrOS, String marca, String nrserie, String modelo, String defeito, String solucao, String dataconclusao, String datacriacao) {
        this.nrOS = nrOS;
        this.marca = marca;
        this.nrserie = nrserie;
        this.modelo = modelo;
        this.defeito = defeito;
        this.solucao = solucao;
        // Captura a data atual do sistema
        Calendar calendar = Calendar.getInstance();
        // Formata a data para o padrão brasileiro (dd/MM/yyyy)
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        this.dataconclusao = formatador.format(calendar.getTime());
        this.datacriacao = this.dataconclusao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNrOS() {
        return nrOS;
    }

    public void setNrOS(int nrOS) {
        this.nrOS = nrOS;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNrserie() {
        return nrserie;
    }

    public void setNrserie(String nrserie) {
        this.nrserie = nrserie;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(String datacriacao) {
        this.datacriacao = datacriacao;
    }

    public String getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(String dataconclusao) {
        this.dataconclusao = dataconclusao;
    }






}
