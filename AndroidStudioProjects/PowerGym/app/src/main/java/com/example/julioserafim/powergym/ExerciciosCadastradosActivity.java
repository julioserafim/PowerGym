package com.example.julioserafim.powergym;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ExerciciosCadastradosActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios_cadastrados);

        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new AdapterExercicios(this));
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int idx, long id){

        String s = (String) parent.getAdapter().getItem(idx);
        if(id == 1){
            Intent i = new Intent(this, VideoExerciciosCadastradosActivity.class);
            startActivity(i);

        }

        Toast.makeText(ExerciciosCadastradosActivity.this, "Exercicio selecionado:" + s + "id" + id, Toast.LENGTH_SHORT).show();
    }

    public void voltarHome(View view){
        Intent home = new Intent(this,TelaInicialActivity.class);
        startActivity(home);
    }



}
