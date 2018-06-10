package com.online.assistencia.assistcell;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewReserva {
    Calendar c = Calendar.getInstance();

    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String formattedDate = df.format(c.getTime());
    private String Titulo;
    private String id;
    private String Marca;
    private String Modelo;
    private String Nome;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = "Reserva de Mercadoria";
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
        return formattedDate;
    }

    public void setData(String data) {
        Data = data;
    }

    public String toString() {
        return "Nome: "+ Nome +"\n"+
                "ID: "+ id +"\n"+
                "Marca: " + Marca + "\n" +
                "Modelo: " + Modelo + "\n"+
                "Email: " + Email + "\n"+
                "Telefone: " + Telefone + "\n"+
                "Data: " + Data + "\n";
    }

    private String Email;
    private String Telefone;
    private String Data;

    public NewReserva(){

    }

}
