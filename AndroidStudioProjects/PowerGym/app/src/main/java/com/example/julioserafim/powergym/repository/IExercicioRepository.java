package com.example.julioserafim.powergym.repository;

import com.example.julioserafim.powergym.Model.Exercicio;

/**
 * Created by julioserafim on 12/2/16.
 */

public interface IExercicioRepository {

    void adicionarExercicio(Exercicio exercicio, long diaSemana);

    void deletarExercicioPorId(Long id);

    void listarExercicios(Exercicio exercicio);

    void alterarExercicio(Exercicio exercicio);
}
