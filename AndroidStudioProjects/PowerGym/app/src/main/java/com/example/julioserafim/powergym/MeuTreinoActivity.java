package com.example.julioserafim.powergym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MeuTreinoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_treino);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void verTreinoDesseDia(View view){
        Intent i = new Intent(this,MostrarTreinoActivity.class);
        startActivity(i);
    }


    public void irMenu(View view){
        Intent i = new Intent(this,TelaInicialActivity.class);
        startActivity(i);
    }
}
