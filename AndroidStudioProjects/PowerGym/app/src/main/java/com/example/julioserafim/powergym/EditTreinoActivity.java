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

public class EditTreinoActivity extends AppCompatActivity {
    private EditText nome;
    private EditText series;
    private EditText tempoDescanso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_treino);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    /*public void salvarTreino(View view){
        nome = (EditText) findViewById(R.id.editTextEditarTreinoNomeTreino);
        series = (EditText)findViewById(R.id.editTextEditarTreinoSeries);
        tempoDescanso = (EditText)findViewById(R.id.editTextEditarTreinoTempoSerie);

        nome.setText("");
        series.setText("");
        tempoDescanso.setText("");

        Toast.makeText(EditTreinoActivity.this, "As alterações foram salvas com sucesso!", Toast.LENGTH_SHORT).show();
    }*/

}
