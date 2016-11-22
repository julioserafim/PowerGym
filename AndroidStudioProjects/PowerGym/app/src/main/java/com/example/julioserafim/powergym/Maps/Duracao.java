package com.example.julioserafim.powergym.Maps;

/**
 * Created by julioserafim on 11/22/16.
 */

public class Duracao {
    private String texto;
    private int duracao;

    public Duracao(String texto, int duracao) {
        this.texto = texto;
        this.duracao = duracao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
