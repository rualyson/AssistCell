package com.online.assistencia.assistcell;

public class NewProduto {

    private String id, marca, modelo, descricao, rb_tela, rb_pelicula, rb_case, rb_fone, rb_diversos, rb_carregador;
    private int quantidade;
    private Double valor;

    public NewProduto(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getRb_tela() {
        return rb_tela;
    }

    public void setRb_tela(String rb_tela) { this.rb_tela = "Telas"; }

    public String getRb_pelicula() {
        return rb_pelicula;
    }

    public void setRb_pelicula(String rb_pelicula) {
        this.rb_pelicula = "Películas";
    }

    public String getRb_case() {
        return rb_case;
    }

    public void setRb_case(String rb_case) {
        this.rb_case = "Capinhas";
    }

    public String getRb_fone() {
        return rb_fone;
    }

    public void setRb_fone(String rb_fone) {
        this.rb_fone = "Fone";
    }

    public String getRb_diversos() {
        return rb_diversos;
    }

    public void setRb_diversos(String rb_diversos) {
        this.rb_diversos = "Diversos";
    }

    public String getRb_carregador() {
        return rb_carregador;
    }

    public void setRb_carregador(String rb_carregador) {
        this.rb_carregador = "Carregador";
    }
}
