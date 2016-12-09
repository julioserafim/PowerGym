package com.example.julioserafim.powergym.Maps;

import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.example.julioserafim.powergym.Model.Academia;
import com.example.julioserafim.powergym.Model.AcademiasEmQuixada;
import com.google.android.gms.maps.model.LatLng;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;





public class AcademiaMaisProxima {

    List<Academia> academias;
    Location academiaAtual = new Location("Academia Atual");
    Location academiaAnterior = new Location("Academia Anterior");


    public Location academiaMaisProxima (Location localizacaoAtual) {
        AcademiasEmQuixada academiasEmQuixada = new AcademiasEmQuixada();

        academias = new ArrayList<Academia>();
        academias = academiasEmQuixada.getAcademiasDeQuixada();

        Academia academiaMaisProxima = null;
        double distanciaAcademiaAnterior = 0;
        double distanciaAcademiaAtual = 0;


        for(int i = 1; i < academias.size(); i++){

            academiaAnterior.setLatitude(academias.get(i-1).getLatitude());
            academiaAnterior.setLongitude(academias.get(i-1).getLongitude());
            distanciaAcademiaAnterior = localizacaoAtual.distanceTo(academiaAnterior);

            academiaAtual.setLatitude(academias.get(i).getLatitude());
            academiaAtual.setLongitude(academias.get(i).getLongitude());
            distanciaAcademiaAtual = localizacaoAtual.distanceTo(academiaAtual);



            if(distanciaAcademiaAtual < distanciaAcademiaAnterior){
                academiaMaisProxima = academias.get(i);
                Log.i("ACADEMIAMAISPROX FOR:", academiaMaisProxima.getNome());

            }


        }

        if(academiaMaisProxima == null){
            academiaMaisProxima = academias.get(0);

        }

        Log.i("ACADEMIAMAISPROX D-NULL", academiaMaisProxima.getNome());
        Log.i("LATITUDE ACADEM", academiaMaisProxima.toString());

        academiaAtual.setLatitude(academiaMaisProxima.getLatitude());
        academiaAtual.setLongitude(academiaMaisProxima.getLongitude());
        Log.i("ACADEMIA ATUAL", academiaAtual.toString());

        return academiaAtual;
    }









}