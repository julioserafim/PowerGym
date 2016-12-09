package com.example.julioserafim.powergym.Maps;

import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julioserafim on 11/22/16.
 */

public class LocalizadorDirecao {

    private static final String DIRECTION_URL_API = "https://maps.googleapis.com/maps/api/directions/json?";
    private static final String GOOGLE_API_KEY = "AIzaSyDp8YUufrJdN6ob1LSc4i2W1TsneYUPQuw";
    private DirecaoLozalizadorListener listener;
    private String origin;
    private String destination;


    public LocalizadorDirecao(DirecaoLozalizadorListener listener, String origin, String destination) {
        this.listener = listener;
        this.origin = origin;
        this.destination = destination;
    }


    public void execute() throws UnsupportedEncodingException { // Chama o método execute para baixar dados
        listener.onDirectionLocalizadorStart();
        new DownloadDadosJson().execute(createUrl());
    }

    private String createUrl() throws UnsupportedEncodingException { // cria url
        String urlOrigin = URLEncoder.encode(origin, "utf-8");
        String urlDestination = URLEncoder.encode(destination, "utf-8");

        Log.i("ORIGEM STRING", origin);
        Log.i("ORIGEM STRING", destination);


        Log.i("API KEY",DIRECTION_URL_API + "origin=" + urlOrigin + "&destination=" + urlDestination + "&key=" + GOOGLE_API_KEY);

        return DIRECTION_URL_API + "origin=" + urlOrigin + "&destination=" + urlDestination + "&key=" + GOOGLE_API_KEY;
    }

    private class DownloadDadosJson extends AsyncTask<String, Void, String> { // Thread que vai fazer o download de dados

        @Override
        protected String doInBackground(String... params) {
            String link = params[0];
            try {
                URL url = new URL(link);
                InputStream is = url.openConnection().getInputStream();
                StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String res) {
            try {
                parseJSon(res);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

    private void parseJSon(String data) throws JSONException { // Converter Json e salvar rotas
        if (data == null)
            return;

        List<Rota> routes = new ArrayList<Rota>();
        JSONObject jsonData = new JSONObject(data);
        JSONArray jsonRotas = jsonData.getJSONArray("routes");

        for (int i = 0; i < jsonRotas.length(); i++) {
            JSONObject jsonRoute = jsonRotas.getJSONObject(i);
            Rota rota = new Rota();

            JSONObject overview_polylineJson = jsonRoute.getJSONObject("overview_polyline");
            JSONArray jsonLegs = jsonRoute.getJSONArray("legs");
            JSONObject jsonLeg = jsonLegs.getJSONObject(0);
            JSONObject jsonDistance = jsonLeg.getJSONObject("distance");
            JSONObject jsonDuration = jsonLeg.getJSONObject("duration");
            JSONObject jsonEndLocation = jsonLeg.getJSONObject("end_location");
            JSONObject jsonStartLocation = jsonLeg.getJSONObject("start_location");

            rota.setDistance(new Distancia(jsonDistance.getString("text"), jsonDistance.getInt("value")));
            rota.setDuration(new Duracao(jsonDuration.getString("text"), jsonDuration.getInt("value")));
            rota.setEndAddress(jsonLeg.getString("end_address"));
            rota.setStartAddress(jsonLeg.getString("start_address"));
            rota.setStartLocation(new LatLng(jsonStartLocation.getDouble("lat"), jsonStartLocation.getDouble("lng")));
            rota.setEndLocation(new LatLng(jsonEndLocation.getDouble("lat"), jsonEndLocation.getDouble("lng")));
            rota.points = decodePolyLine(overview_polylineJson.getString("points"));

            routes.add(rota);
        }

        listener.onDirectionLocalizadorSuccesso(routes);
    }

    private List<LatLng> decodePolyLine(final String poly) { // desenhar as linhas das rotas
        int len = poly.length();
        int index = 0;
        List<LatLng> decoded = new ArrayList<LatLng>();
        int lat = 0;
        int lng = 0;

        while (index < len) {
            int b;
            int shift = 0;
            int result = 0;
            do {
                b = poly.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = poly.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            decoded.add(new LatLng(
                    lat / 100000d, lng / 100000d
            ));
        }

        return decoded;
    }
}