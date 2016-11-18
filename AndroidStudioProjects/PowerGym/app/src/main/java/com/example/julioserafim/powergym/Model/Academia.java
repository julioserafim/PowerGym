package com.example.julioserafim.powergym.Model;

/**
 * Created by julioserafim on 11/18/16.
 */

public class Academia {
    private String nome;
    private double latitude;
    private double longitude;
    private String endereco;

    public Academia(String nome, double latitude, double longitude, String endereco) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
