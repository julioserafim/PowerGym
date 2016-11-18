package com.example.julioserafim.powergym.Model;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by julioserafim on 11/12/16.
 */
public class Exercicio extends RealmObject{

    @PrimaryKey
    private int codigo;
    private String nomeExercicio;
    private String series;
    private String peso;
    private String numeroRepeticoes;
    private String tempoDescanso;
    private int diaSemana;

    public Exercicio(int codigo, String nomeExercicio, String series, String peso, String numeroRepeticoes, String tempoDescanso, int diaSemana) {
        this.codigo = codigo;
        this.nomeExercicio = nomeExercicio;
        this.series = series;
        this.peso = peso;
        this.numeroRepeticoes = numeroRepeticoes;
        this.tempoDescanso = tempoDescanso;
        this.diaSemana = diaSemana;
    }

    public Exercicio(){}


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTempoDescanso() {
        return tempoDescanso;
    }

    public void setTempoDescanso(String tempoDescanso) {
        this.tempoDescanso = tempoDescanso;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getNumeroRepeticoes() {
        return numeroRepeticoes;
    }

    public void setNumeroRepeticoes(String numeroRepeticoes) {
        this.numeroRepeticoes = numeroRepeticoes;
    }
}
