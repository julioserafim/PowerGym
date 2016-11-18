package com.example.julioserafim.powergym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.julioserafim.powergym.Model.Exercicio;

import io.realm.Realm;

public class AlteracaoRemocaoTreinoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alteracao_remocao_treino);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Realm realm = Realm.getDefaultInstance();
        Intent intent = getIntent();
        int codigo = intent.getIntExtra("Id",0);
        Exercicio exercicio = realm.where(Exercicio.class).equalTo("codigo",codigo).findFirst();

        EditText nomeExercicio = (EditText)findViewById(R.id.editTextNomeExercicio);
        EditText numeroSeries = (EditText)findViewById(R.id.editTextNumeroSeries);
        EditText peso = (EditText)findViewById(R.id.editTextPeso);
        EditText numeroRepeticoes = (EditText)findViewById(R.id.editTextNumeroRepeticoes);
        EditText tempoDescanso = (EditText)findViewById(R.id.editTextTempoDescanso);

        nomeExercicio.setText(exercicio.getNomeExercicio());
        numeroSeries.setText(exercicio.getSeries());
        peso.setText(exercicio.getPeso());
        numeroRepeticoes.setText(exercicio.getNumeroRepeticoes());
        tempoDescanso.setText(exercicio.getTempoDescanso());


        Button alterar = (Button)findViewById(R.id.buttonAlterar);



    }

    public void alterarDados(View view){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

    }

}
