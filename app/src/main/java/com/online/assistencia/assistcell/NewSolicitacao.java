package com.online.assistencia.assistcell;

public class NewSolicitacao {
    private String id;
    private String Marca;
    private String Modelo;
    private String Produto;
    private String Quant;
    private String Nome;
    private String Email;
    private String Telefone;

    public NewSolicitacao(){

    }



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

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String produto) {
        Produto = produto;
    }

    public String getQuant() {
        return Quant;
    }

    public void setQuant(String quant) {
        Quant = quant;
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
}
