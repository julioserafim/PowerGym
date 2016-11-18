package com.example.julioserafim.powergym;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculoIMCActivity extends AppCompatActivity {
    private EditText altura;
    private EditText peso;
    private TextView resultadoEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

    }

    public void calcularIMC(View view){
        double resultado;
        double alturaValor;
        double pesoValor;

        altura = (EditText) findViewById(R.id.editTextAltura);
        peso = (EditText)findViewById(R.id.editTextPeso);
        resultadoEdit = (TextView)findViewById(R.id.textViewResultado);


        alturaValor = Double.parseDouble(altura.getText().toString());
        pesoValor = Double.parseDouble(peso.getText().toString());


        resultado = pesoValor/(alturaValor * alturaValor);

        resultadoEdit.setText("" + resultado);


    }

}
