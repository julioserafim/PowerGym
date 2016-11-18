package com.example.julioserafim.powergym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AcademiaProximaActivity extends AppCompatActivity {

    Random r;
    private static final String ACADEMIA = "ACADEMIA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academia_proxima);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = (TextView)findViewById(R.id.textViewMockup);
        textView.setBackgroundResource(R.drawable.mockup);

        Intent intent = new Intent(AcademiaProximaActivity.this, NotificarAcademiaService.class);
        String academia = sorteia();

        intent.putExtra(ACADEMIA,academia);
        startService(intent);


    }

    public void irParaMenu(View view){
        Intent i = new Intent(this,TelaInicialActivity.class);
        startActivity(i);

    }

    public String sorteia(){
        String[] academias = new String[] {"Imperius Fitness","TopTreino","Proforma","World Fitness"};
        int i = new Random().nextInt(academias.length);
        String random = (academias[i]);
        return random;
    }

}
