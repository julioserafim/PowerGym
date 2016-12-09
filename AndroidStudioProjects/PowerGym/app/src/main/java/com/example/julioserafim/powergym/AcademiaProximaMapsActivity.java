package com.example.julioserafim.powergym;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.julioserafim.powergym.Maps.AcademiaMaisProxima;
import com.example.julioserafim.powergym.Maps.DirecaoLozalizadorListener;
import com.example.julioserafim.powergym.Maps.LocalizadorDirecao;
import com.example.julioserafim.powergym.Maps.Rota;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AcademiaProximaMapsActivity extends FragmentActivity implements OnMapReadyCallback, DirecaoLozalizadorListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private GoogleMap mMap;
    private Button btnFindPath;
    private LatLng origem;
    private LatLng destino;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private Location academiaMaisProxima;

    private String locOrigem;
    private String locDestino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academia_proxima_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        btnFindPath = (Button) findViewById(R.id.btnFindPath);


        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }


        btnFindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

    }

    private void sendRequest() {

        if (locOrigem.isEmpty()) {
            Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (locDestino.isEmpty()) {
            Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            new LocalizadorDirecao(this, locOrigem, locDestino).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
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

        LatLng hcmus = new LatLng(-4.358930, -39.308357);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hcmus, 18));
        originMarkers.add(mMap.addMarker(new MarkerOptions()
                .title("Canindé")
                .position(hcmus)));


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }


        mMap.setMyLocationEnabled(true);


    }

    @Override
    public void onDirectionLocalizadorStart() {
        progressDialog = ProgressDialog.show(this, "Aguarde",
                "Encontrando Academia!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline : polylinePaths) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionLocalizadorSuccesso(List<Rota> routes) { // Desenhar as rotas na tela
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Rota route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.getStartLocation(), 16)); // Move a câmera
            ((TextView) findViewById(R.id.tvDuration)).setText(route.getDuration().getText());
            ((TextView) findViewById(R.id.tvDistance)).setText(route.getDistance().getText());

            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
                    .title(route.getStartAddress())
                    .position(route.getStartLocation())));
            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
                    .title(route.getEndAddress())
                    .position(route.getEndLocation())));

            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.BLUE).
                    width(10);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null){
            //origem = new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());
            //AcademiaMaisProxima.academiaMaisProxima(mLastLocation);
            AcademiaMaisProxima academia = new AcademiaMaisProxima();
            academiaMaisProxima = academia.academiaMaisProxima(mLastLocation);


            double latitude = mLastLocation.getLatitude();
            String latitudeString = String.valueOf(latitude);
            latitude = Double.parseDouble(latitudeString.replace(",","."));
            latitudeString = String.valueOf(latitude);

            double longitude = mLastLocation.getLongitude();
            String longitudeString = String.valueOf(longitude);
            longitude = Double.parseDouble(longitudeString.replace(",","."));
            longitudeString = String.valueOf(longitude);

            double latitudeD = academiaMaisProxima.getLatitude();
            String latitudeStringD = String.valueOf(latitudeD);
            latitudeD = Double.parseDouble(latitudeStringD.replace(",","."));
            latitudeStringD = String.valueOf(latitudeD);

            Toast.makeText(this, "Academia mais próxima:" + academia.academia(), Toast.LENGTH_SHORT).show();
            double longitudeD = academiaMaisProxima.getLongitude();

            String longitudeStringD = String.valueOf(longitudeD);
            longitudeD = Double.parseDouble(longitudeStringD.replace(",","."));
            longitudeStringD = String.valueOf(longitudeD);



            locOrigem = latitudeString+","+" "+longitudeString;
            locDestino = latitudeStringD+","+" "+longitudeStringD;


            //locOrigem = locationStringFromLocation(mLastLocation);
            Log.i("LOC ORIGEM", locOrigem);
            Log.i("LOC DESTINO", locDestino);
            //Toast.makeText(this, "ORIGEM " + locOrigem, Toast.LENGTH_SHORT).show();
        }



    }

    public static String locationStringFromLocation(final Location location) {
        return Location.convert(location.getLatitude(), Location.FORMAT_DEGREES) + " " + Location.convert(location.getLongitude(), Location.FORMAT_DEGREES);
    }

    public static String locationStringFromLocation(final double latitude, double longitude) {
        return Location.convert(latitude, Location.FORMAT_DEGREES) + " " + Location.convert(longitude, Location.FORMAT_DEGREES);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(this, "Problema na conexão", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "Problema na conexão", Toast.LENGTH_SHORT).show();

    }



}