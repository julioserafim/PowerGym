/*
package com.example.julioserafim.powergym.Maps;

import android.util.Log;
import android.widget.Toast;

import com.example.julioserafim.powergym.Model.Academia;
import com.example.julioserafim.powergym.Model.AcademiasEmQuixada;
import com.google.android.gms.maps.model.LatLng;

import java.text.DecimalFormat;
import java.util.List;

*/
/**
 * Created by julioserafim on 11/25/16.
 *//*


public class AcademiaMaisProxima {

    List<Academia> academias;


   */
/* public LatLng academiaMaisProxima (LatLng minhaLocalizacaoAtual){
        LatLng locAcademiaAtual;
        double distancia = 0;
        double latitude;
        double longitude;

        AcademiasEmQuixada academiaObjeto = new AcademiasEmQuixada();
        academias = academiaObjeto.getAcademiasDeQuixada();

       academiaAtual =  academias.get(0);

        for(int i = 1; i < academias.size(); i++){
            academiaAtual = academias.get(i);
            latitude = academiaAtual.getLatitude();
            longitude = academiaAtual.getLongitude();

            locAcademiaAtual = new LatLng(latitude,longitude);

            Dis

        }*//*



        //Retornar a LATLONG da academia mais perto para o service



    }




    public double DistanciaEntreDoisLugares(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));


        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);


       */
/* double valor = Radius * c;
        Toast.makeText(this, "Valor:" + valor, Toast.LENGTH_SHORT).show();


        return Radius * c;*//*



    //}

}
*/
