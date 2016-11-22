package com.example.julioserafim.powergym.Maps;

/**
 * Created by julioserafim on 11/22/16.
 */

public class Distancia {
    private String texto;
    private int distancia;

    public Distancia(String texto, int distancia) {
        this.texto = texto;
        this.distancia = distancia;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}
