package com.example.julioserafim.powergym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.julioserafim.powergym.Model.DiasDaSemana;
import com.example.julioserafim.powergym.Model.DiasDaSemanaAdapter;

import java.util.List;

/**
 * Created by julioserafim on 12/3/16.
 */

public class DiasDaSemanaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
        private ListView listView;
        private List<DiasDaSemana> diasDaSemana;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dias_semana_listview);

        listView = (ListView)findViewById(R.id.listviewDiasSemana);
        diasDaSemana = DiasDaSemana.getDiasDaSemana();
        listView.setAdapter(new DiasDaSemanaAdapter(this,diasDaSemana));
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            DiasDaSemana d = this.diasDaSemana.get(position);
            Intent i = new Intent(this, ListaDeExerciciosMeuTreinoActivity.class);
            i.putExtra("codigoDiaSemana",id);
            startActivity(i);
    }
}
