package com.online.assistencia.assistcell;

import android.widget.EditText;

public class NewPrecoForn {
    private String id, marca, modelo,descricao, valorCompra, cnpj, codIdentificacao, fornecedor , rb_telas, rb_peliculas, rb_fone, rb_cases, rb_carregador,rb_diversos;

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

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodIdentificacao() {
        return codIdentificacao;
    }

    public void setCodIdentificacao(String codIdentificacao) {
        this.codIdentificacao = codIdentificacao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
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

    public NewPrecoForn(){

    }

    public String toString() {
        if(rb_telas!=null){
            return  "Categoria = "+rb_telas+'\n'+
                    "Marca = " + marca + '\n' +
                    "Modelo = " + modelo + '\n' +
                    "Descrição = " + descricao + '\n' +
                    "Valor de Compra = " + valorCompra + '\n' +
                    "CNPJ = " + cnpj + '\n' +
                    "Cod. Identificação = " + codIdentificacao + '\n' +
                    "Fornecedor = " + fornecedor + '\n' ;
        }else if(rb_peliculas!=null){
            return  "Categoria = "+rb_peliculas+'\n'+
                    "Marca = " + marca + '\n' +
                    "Modelo = " + modelo + '\n' +
                    "Descrição = " + descricao + '\n' +
                    "Valor de Compra = " + valorCompra + '\n' +
                    "CNPJ = " + cnpj + '\n' +
                    "Cod. Identificação = " + codIdentificacao + '\n' +
                    "Fornecedor = " + fornecedor + '\n' ;
        }else if(rb_fone!=null){
            return  "Categoria = "+rb_fone+'\n'+
                    "Marca = " + marca + '\n' +
                    "Modelo = " + modelo + '\n' +
                    "Descrição = " + descricao + '\n' +
                    "Valor de Compra = " + valorCompra + '\n' +
                    "CNPJ = " + cnpj + '\n' +
                    "Cod. Identificação = " + codIdentificacao + '\n' +
                    "Fornecedor = " + fornecedor + '\n' ;
        }else if(rb_cases!=null){
            return  "Categoria = "+rb_cases+'\n'+
                    "Marca = " + marca + '\n' +
                    "Modelo = " + modelo + '\n' +
                    "Descrição = " + descricao + '\n' +
                    "Valor de Compra = " + valorCompra + '\n' +
                    "CNPJ = " + cnpj + '\n' +
                    "Cod. Identificação = " + codIdentificacao + '\n' +
                    "Fornecedor = " + fornecedor + '\n' ;
        }else if(rb_carregador!=null){
            return  "Categoria = "+rb_carregador+'\n'+
                    "Marca = " + marca + '\n' +
                    "Modelo = " + modelo + '\n' +
                    "Descrição = " + descricao + '\n' +
                    "Valor de Compra = " + valorCompra + '\n' +
                    "CNPJ = " + cnpj + '\n' +
                    "Cod. Identificação = " + codIdentificacao + '\n' +
                    "Fornecedor = " + fornecedor + '\n' ;
        }else{
            return  "Categoria = "+rb_diversos+'\n'+
                    "Marca = " + marca + '\n' +
                    "Modelo = " + modelo + '\n' +
                    "Descrição = " + descricao + '\n' +
                    "Valor de Compra = " + valorCompra + '\n' +
                    "CNPJ = " + cnpj + '\n' +
                    "Cod. Identificação = " + codIdentificacao + '\n' +
                    "Fornecedor = " + fornecedor + '\n' ;
        }

    }
}
