package com.online.assistencia.assistcell;

public class NewOrcamento {
    private String id, nomeCli, Marca, Modelo, EstadoF, Relato, Contato, Email, rb_receberPorSms, receberPorEmail, rb_buscarNaAssistencia;

    public void NewOrcamento(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getEstadoF() {
        return EstadoF;
    }

    public void setEstadoF(String estadoF) {
        EstadoF = estadoF;
    }

    public String getRelato() {
        return Relato;
    }

    public void setRelato(String relato) {
        Relato = relato;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String contato) {
        Contato = contato;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRb_sms() {
        return rb_receberPorSms;
    }

    public void setRb_sms(String rb_sms) {
        this.rb_receberPorSms = "Receber por SMS";
    }

    public String getRb_email() {
        return receberPorEmail;
    }

    public void setRb_email(String rb_email) {
        this.receberPorEmail = "Receber por email";
    }

    public String getRb_buscarAssist() {
        return rb_buscarNaAssistencia;
    }

    public void setRb_buscarAssist(String rb_buscarAssist) {
        this.rb_buscarNaAssistencia = "Buscar na Assistência Técnica";
    }
}
