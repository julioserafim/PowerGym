package com.example.julioserafim.powergym.Model;

import com.example.julioserafim.powergym.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julioserafim on 12/2/16.
 */

public class DiasDaSemana {
    public String nome;
    public int img; // R.drawable.xxx

    public DiasDaSemana(String nome, int img) {
        this.nome = nome;
        this.img = img;
    }

    public static List<DiasDaSemana> getDiasDaSemana() {
        // Planetas
        List<DiasDaSemana> planetas = new ArrayList<DiasDaSemana>();
        planetas.add(new DiasDaSemana("Segunda-Feira", R.drawable.segunda_feira));
        planetas.add(new DiasDaSemana("Terça-Feira", R.drawable.terca_feira));
        planetas.add(new DiasDaSemana("Quarta-Feira", R.drawable.quarta_feira));
        planetas.add(new DiasDaSemana("Quinta-Feira", R.drawable.quinta_feira));
        planetas.add(new DiasDaSemana("Sexta-Feira", R.drawable.sexta_feira));
        planetas.add(new DiasDaSemana("Saábado", R.drawable.sabado));
        return planetas;
    }
}
