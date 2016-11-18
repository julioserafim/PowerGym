package com.example.julioserafim.powergym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.julioserafim.powergym.Model.Exercicio;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmModel;

public class TelaInicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        TextView textView = (TextView)findViewById(R.id.textViewLogo);
        textView.setBackgroundResource(R.drawable.logo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

       // Exercicio exercicio1 = new Exercicio(1,"Supino","4","34kg","8-10","5 segundos",1);
       // Exercicio exercicio2 = new Exercicio(2,"SupinoFlexionado","4","34kg","8-10","5 segundos",1);
        //realm.copyToRealm(exercicio2);
        //Toast.makeText(TelaInicialActivity.this, "Dados Salvos!", Toast.LENGTH_SHORT).show();

       // realm.commitTransaction();
        //realm.close();


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

        if (id == R.id.modificar_treino) {
            Intent i = new Intent(this,EditTreinoActivity.class);
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
