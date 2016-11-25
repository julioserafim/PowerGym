package com.example.julioserafim.powergym.Maps;

/**
 * Created by julioserafim on 11/22/16.
 */

public class Distancia {
    private String text;
    private int value;

    public Distancia(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
