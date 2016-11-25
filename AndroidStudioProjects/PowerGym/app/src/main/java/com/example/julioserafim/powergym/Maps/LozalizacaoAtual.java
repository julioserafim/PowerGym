package com.example.julioserafim.powergym.Maps;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by julioserafim on 11/25/16.
 */

public class LozalizacaoAtual {
    private String endereco;
    private LatLng coordenadas;

    public LozalizacaoAtual(String endereco, LatLng coordenadas) {
        this.endereco = endereco;
        this.coordenadas = coordenadas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LatLng getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(LatLng coordenadas) {
        this.coordenadas = coordenadas;
    }




}
