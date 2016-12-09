package com.example.julioserafim.powergym;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ExerciciosCadastradosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios_cadastrados);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new AdapterExercicios(this));
        listView.setOnItemClickListener(this);
    }



    public void onItemClick(AdapterView<?> parent, View view, int idx, long id){

        String s = (String) parent.getAdapter().getItem(idx);

            Intent i = new Intent(this, VideoExerciciosCadastradosActivity.class);
            i.putExtra(VideoExerciciosCadastradosActivity.VIDEO,id);
            startActivity(i);



       // Toast.makeText(ExerciciosCadastradosActivity.this, "Exercicio selecionado:" + s + "id" + id, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tela_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.meu_treino) {
            Intent i = new Intent(this,ListaDeExerciciosMeuTreinoActivity.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.academia_proxima) {
            Intent i = new Intent(this,AcademiaProximaMapsActivity.class);
            startActivity(i);
            return true;
        }


        if (id == R.id.exercicios_cadastrados) {
            Intent i = new Intent(this,ExerciciosCadastradosActivity.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.cacular_imc) {
            Intent i = new Intent(this,CalculoIMCActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
