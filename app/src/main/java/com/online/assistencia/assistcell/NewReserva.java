package com.online.assistencia.assistcell;

public class NewReserva {

    private String id;
    private String Marca;
    private String Modelo;
    private String Nome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    private String Email;
    private String Telefone;
    private String Data;

    public NewReserva(){

    }

}
