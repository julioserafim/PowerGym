package com.example.julioserafim.powergym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.julioserafim.powergym.Model.Exercicio;
import com.example.julioserafim.powergym.Model.ExercicioAdapter;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmSchema;

public class ListaDeExerciciosMeuTreinoActivity extends AppCompatActivity {
        private List<Exercicio> exercicios;
        private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_exercicios_meu_treino);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();
        Intent i = getIntent();
        long id = 0;
        final long valor;
        valor = i.getLongExtra("codigoDiaSemana",id);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaDeExerciciosMeuTreinoActivity.this,AdicionarActivity.class);
                i.putExtra("codigoDiaSemana",valor);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mostrarExercicioDeAcordoComODia();
    }

    public void mostrarExercicioDeAcordoComODia(){
        Intent i = getIntent();
        long id = 0;
        final long valor;
        valor = i.getLongExtra("codigoDiaSemana",id);

        ListView exerciciosListView = (ListView)findViewById(R.id.listViewExercicios);

        exercicios = realm.where(Exercicio.class).equalTo("diaSemana",valor).findAll();
        ExercicioAdapter adapter = new ExercicioAdapter(this,exercicios);
        exerciciosListView.setAdapter(adapter);


        //Click cada item
        exerciciosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(ListaDeExerciciosMeuTreinoActivity.this,AlteracaoRemocaoTreinoActivity.class);
                intent.putExtra("Id",exercicios.get(i).getCodigo());
                intent.putExtra("codigoDiaSemana",valor);


                startActivity(intent);
            }
        });
    }

}
