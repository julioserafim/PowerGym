package com.example.julioserafim.powergym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.julioserafim.powergym.Model.Exercicio;
import com.example.julioserafim.powergym.repository.ImplementacaoExercicioRepository;

public class AdicionarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);
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
    }


    public void adicionarExercicio(View view){
        Intent i = getIntent();
        long id = 0;
        long valor;
        valor = i.getLongExtra("codigoDiaSemana",id);

        EditText nomeExercicio = (EditText)findViewById(R.id.editTextNomeExercicio);
        EditText numeroRepeticoes = (EditText)findViewById(R.id.editTextNumeroRepeticoes);
        EditText peso = (EditText)findViewById(R.id.editTextPeso);
        EditText numeroSeries = (EditText)findViewById(R.id.editTextNumeroSeries);
        EditText tempoDescanso = (EditText)findViewById(R.id.editTextTempoDescanso);

        Exercicio exercicio = new Exercicio();
        exercicio.setNomeExercicio(nomeExercicio.getText().toString());
        exercicio.setNumeroRepeticoes(numeroRepeticoes.getText().toString());
        exercicio.setTempoDescanso(tempoDescanso.getText().toString());
        exercicio.setPeso(peso.getText().toString());
        exercicio.setSeries(numeroSeries.getText().toString());

        ImplementacaoExercicioRepository dao = new ImplementacaoExercicioRepository();
        if(exercicio != null){
            dao.adicionarExercicio(exercicio,valor);
            Toast.makeText(this, "Exercício Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            nomeExercicio.setText("");
            numeroRepeticoes.setText("");
            peso.setText("");
            numeroSeries.setText("");
            tempoDescanso.setText("");

        }
    }

}
