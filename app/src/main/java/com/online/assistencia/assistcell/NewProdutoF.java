package com.online.assistencia.assistcell;

public class NewProdutoF {
    private String id, marcaProdF, modeloProdF, desProdF,quantProdF, rb_telas, rb_peliculas, rb_fone, rb_cases, rb_carregador,rb_diversos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarcaProdF() {
        return marcaProdF;
    }

    public void setMarcaProdF(String marcaProdF) {
        this.marcaProdF = marcaProdF;
    }

    public String getModeloProdF() {
        return modeloProdF;
    }

    public void setModeloProdF(String modeloProdF) {
        this.modeloProdF = modeloProdF;
    }

    public String getDesProdF() {
        return desProdF;
    }

    public void setDesProdF(String desProdF) {
        this.desProdF = desProdF;
    }

    public String getQuantProdF() {
        return quantProdF;
    }

    public void setQuantProdF(String quantProdF) {
        this.quantProdF = quantProdF;
    }

    public String getRb_telas() {
        return rb_telas;
    }

    public void setRb_telas(String rb_telas) {
        this.rb_telas = "Telas";
    }

    public String getRb_peliculas() {
        return rb_peliculas;
    }

    public void setRb_peliculas(String rb_peliculas) {
        this.rb_peliculas = "Peliculas";
    }

    public String getRb_fone() {
        return rb_fone;
    }

    public void setRb_fone(String rb_fone) {
        this.rb_fone = "Fones de ouvido";
    }

    public String getRb_cases() {
        return rb_cases;
    }

    public void setRb_cases(String rb_cases) {
        this.rb_cases = "Capinhas";
    }

    public String getRb_carregador() {
        return rb_carregador;
    }

    public void setRb_carregador(String rb_carregador) {
        this.rb_carregador = "Carregador";
    }

    public String getRb_diversos() {
        return rb_diversos;
    }

    public void setRb_diversos(String rb_diversos) {
        this.rb_diversos = "Diversos";
    }

    public NewProdutoF(){

    }

    @Override
    public String toString() {
        return  "Marca = " + marcaProdF + '\n' +
                "Modelo = " + modeloProdF + '\n' +
                "Descrição = " + desProdF + '\n' +
                "Quantidade = " + quantProdF + '\n';
    }
}
