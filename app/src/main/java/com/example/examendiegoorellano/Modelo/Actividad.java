package com.example.examendiegoorellano.Modelo;

import java.io.Serializable;

public class Actividad implements Serializable {

    public String titulo;
    public String descricion;


    public Actividad(String titulo, String descricion) {
        this.titulo = titulo;
        this.descricion = descricion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }
}
