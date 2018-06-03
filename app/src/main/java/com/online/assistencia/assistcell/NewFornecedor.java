package com.online.assistencia.assistcell;

public class NewFornecedor {

    private String id;
    private String empresa;
    private String representante;
    private String endereco;
    private String numeroEnd;
    private String bairroEnd;
    private String cidadeEnd;
    private String cepEnd;
    private String ufEnd;
    private String paisEnd;
    private String complEnd;
    private String refEnd;
    private String email;
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    private String contact;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroEnd() {
        return numeroEnd;
    }

    public void setNumeroEnd(String numeroEnd) {
        this.numeroEnd = numeroEnd;
    }

    public String getBairroEnd() {
        return bairroEnd;
    }

    public void setBairroEnd(String bairroEnd) {
        this.bairroEnd = bairroEnd;
    }

    public String getCidadeEnd() {
        return cidadeEnd;
    }

    public void setCidadeEnd(String cidadeEnd) {
        this.cidadeEnd = cidadeEnd;
    }

    public String getCepEnd() {
        return cepEnd;
    }

    public void setCepEnd(String cepEnd) {
        this.cepEnd = cepEnd;
    }

    public String getUfEnd() {
        return ufEnd;
    }

    public void setUfEnd(String ufEnd) {
        this.ufEnd = ufEnd;
    }

    public String getPaisEnd() {
        return paisEnd;
    }

    public void setPaisEnd(String paisEnd) {
        this.paisEnd = paisEnd;
    }

    public String getComplEnd() {
        return complEnd;
    }

    public void setComplEnd(String complEnd) {
        this.complEnd = complEnd;
    }

    public String getRefEnd() {
        return refEnd;
    }

    public void setRefEnd(String refEnd) {
        this.refEnd = refEnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Empresa: "+ empresa +"\n"+
                "CNPJ: "+ cnpj +"\n"+
                "Representante: " + representante + "\n" +
                "Endereco: " + endereco + "\n"+
                "Numero: " + numeroEnd + "\n"+
                "Bairro: " + bairroEnd + "\n"+
                "Complemento: " + complEnd + "\n"+
                "Ponto de Ref.: " + refEnd + "\n"+
                "Cidade: " + cidadeEnd + "\n"+
                "Cep: " + cepEnd + "\n"+
                "UF: " + ufEnd + "\n"+
                "País: " + paisEnd + "\n"+
                "E-mail: " + email + "\n"+
                "Telefone: " + contact + "\n";
    }

    public NewFornecedor(){

    }


}
