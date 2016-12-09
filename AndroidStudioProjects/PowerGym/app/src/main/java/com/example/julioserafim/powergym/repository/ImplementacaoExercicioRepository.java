package com.example.julioserafim.powergym.repository;

import com.example.julioserafim.powergym.Model.Exercicio;

import java.util.UUID;

import io.realm.Realm;

/**
 * Created by julioserafim on 12/2/16.
 */

public class ImplementacaoExercicioRepository implements IExercicioRepository {
    @Override
    public void adicionarExercicio(Exercicio exercicio, long diaSemana) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Exercicio realmExercicio = realm.createObject(Exercicio.class);
        int proximoId = 1;
        if(realm.where(Exercicio.class).max("codigo") != null)
            proximoId = realm.where(Exercicio.class).max("codigo").intValue() + 1;
        realmExercicio.setCodigo(proximoId);
        realmExercicio.setDiaSemana(diaSemana);
        realmExercicio.setNomeExercicio(exercicio.getNomeExercicio());
        realmExercicio.setNumeroRepeticoes(exercicio.getNumeroRepeticoes());
        realmExercicio.setPeso(exercicio.getPeso());
        realmExercicio.setSeries(exercicio.getSeries());
        realmExercicio.setTempoDescanso(exercicio.getTempoDescanso());


        realm.commitTransaction();
    }

    @Override
    public void deletarExercicioPorId(Long id) {

    }

    @Override
    public void listarExercicios(Exercicio exercicio) {

    }

    @Override
    public void alterarExercicio(Exercicio exercicio) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Exercicio realmExercicio = realm.createObject(Exercicio.class);
        realmExercicio.setNomeExercicio(exercicio.getNomeExercicio());
        realmExercicio.setNumeroRepeticoes(exercicio.getNumeroRepeticoes());
        realmExercicio.setPeso(exercicio.getPeso());
        realmExercicio.setSeries(exercicio.getSeries());
        realmExercicio.setTempoDescanso(exercicio.getTempoDescanso());
        realm.copyToRealm(realmExercicio);
        realm.commitTransaction();
        

    }
}
