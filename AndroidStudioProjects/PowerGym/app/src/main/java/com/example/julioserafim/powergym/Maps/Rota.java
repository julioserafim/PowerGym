package com.example.julioserafim.powergym.Maps;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by julioserafim on 11/22/16.
 */

public class Rota {
    private Distancia distance;
    private Duracao duration;
    private String endAddress;
    private LatLng endLocation;
    private String startAddress;
    private LatLng startLocation;

    public List<LatLng> points;


    public Distancia getDistance() {
        return distance;
    }

    public void setDistance(Distancia distance) {
        this.distance = distance;
    }

    public Duracao getDuration() {
        return duration;
    }

    public void setDuration(Duracao duration) {
        this.duration = duration;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public LatLng getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(LatLng startLocation) {
        this.startLocation = startLocation;
    }

    public List<LatLng> getPoints() {
        return points;
    }

    public void setPoints(List<LatLng> points) {
        this.points = points;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public LatLng getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LatLng endLocation) {
        this.endLocation = endLocation;
    }
}
