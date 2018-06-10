package com.online.assistencia.assistcell;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewNotificacao {

    Calendar c = Calendar.getInstance();

    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String formattedDate = df.format(c.getTime());
    public String titulo;
    public String id_reserva;
    public String imagem;
    public String data_reserva;
    public String nome_cliente;
    public String marca_reservada;
    public String modelo_reservado;
    public NewNotificacao(){

    }

    public String getTitulo() {
        return titulo;
    }

    public String getData_reserva() {
        return formattedDate;
    }

    public void setData_reserva(String data_reserva) {
        this.data_reserva = data_reserva;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getMarca_reservada() {
        return marca_reservada;
    }

    public void setMarca_reservada(String marca_reservada) {
        this.marca_reservada = marca_reservada;
    }

    public String getModelo_reservado() {
        return modelo_reservado;
    }

    public void setModelo_reservado(String modelo_reservado) {
        this.modelo_reservado = modelo_reservado;
    }

    public String toString() {
        return titulo+ '\n' +
                "--------------------------------------- "+ '\n' +
                "Código de Reserva: "+ id_reserva+ '\n' +
                "Data: " + data_reserva + "\n";
    }
}
