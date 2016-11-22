package com.example.julioserafim.powergym;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.text.DecimalFormat;

public class AcademiaProximaMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academia_proxima_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); //Função iniciar o serviço de mapas
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        /*String origem = "-4.358125, -39.311350";
        String destino = "-4.363228, -39.317026";
        String url = "http://maps.googleapis.com/maps?f=d&saddr=" +origem+"&daddr="+destino+"&hl=pt";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));*/



        // Add a marker in Sydney and move the camera
        LatLng casaCaninde = new LatLng(-4.361010, -39.312737); //Valores aleatórios
       /* mMap.addMarker(new MarkerOptions()
                .position(caninde)
                .title("Marker in Canindé")
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_localization)) Adicionar Icone

        );*/


        LatLng casaQuixada = new LatLng(-4.967879, -39.026165); //Valores aleatórios
       /* mMap.addMarker(new MarkerOptions()
                        .position(pracaDoRomeiro)
                        .title("Praça do Romeiro")
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_localization)) Adicionar Icone

        );*/

       /* PolylineOptions linha = new PolylineOptions();
        linha.add(caninde);
        linha.add(pracaDoRomeiro);
        linha.color(Color.BLUE);
        Polyline polyline = mMap.addPolyline(linha);
        polyline.setGeodesic(true);*/




        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(caninde, 18));// MOverá Sidney para o centro da sua tela

        //3 diferentes de mapa google maps MAP_TYPE NORMAL, MAP_TYPE_SATELITE, MAP_TYPE_TERRAIN

        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); // Tipo de mapa

        /*if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);*/

        //CalculationByDistance(casaCaninde,casaQuixada);

        Location caninde = new Location("casa caninde");
        caninde.setLatitude(-4.361010);
        caninde.setLongitude(-39.312737);


        Location quixada = new Location("casa quixada");
        quixada.setLatitude(-4.967879);
        quixada.setLongitude(-39.026165);

        float distancia = caninde.distanceTo(quixada);
        float distanciaKm = (distancia/1000);
        Log.i("DISTÂNCA", "" + distanciaKm + "KM");

    }

    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
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


        double valor = Radius * c;
        Toast.makeText(this, "Valor:" + valor  , Toast.LENGTH_SHORT).show();


        return Radius * c;


    }
}
