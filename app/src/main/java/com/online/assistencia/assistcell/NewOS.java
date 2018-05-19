package com.online.assistencia.assistcell;

public class NewOS {
    private String id;
    private String nomeCli;
    private String Marca;
    private String Modelo;
    private String Imei;
    private String EstadoF;
    private String Relato;
    private String Contato;
    private String Email;
    private String Horario;
    private String ac_chip;
    private String ac_cartaosd;
    private String ac_carregador;
    private String ac_outros;
    private String text_outros;
    private String ac_sem;




    public NewOS() {
    }

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

    public String getImei() {
        return Imei;
    }

    public void setImei(String imei) {
        Imei = imei;
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

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {

        Horario = horario;
    }

    public String getAc_chip() {
        return ac_chip;
    }

    public void setAc_chip(String ac_chip) {
        this.ac_chip = "Chip";
    }

    public String getAc_cartaosd() {
        return ac_cartaosd;
    }

    public void setAc_cartaosd(String ac_cartaosd) {
        this.ac_cartaosd = "Cartão de memória";
    }

    public String getAc_carregador() {
        return ac_carregador;
    }

    public void setAc_carregador(String ac_carregador) {

        this.ac_carregador = "Carregador";
    }
    public String getAc_outros() {
        return ac_outros;
    }

    public void setAc_outros(String ac_outros) {

        this.ac_outros = "Outros";
    }
    public String getText_outros() {
        return text_outros;
    }

    public void setText_outros(String text_outros) {
        this.text_outros = text_outros;
    }
    public String getAc_sem() {
        return ac_sem;
    }

    public void setAc_sem(String acSem) {
        this.ac_sem = "Sem acessorios";
    }

    public void NewOs(){

    }
}
