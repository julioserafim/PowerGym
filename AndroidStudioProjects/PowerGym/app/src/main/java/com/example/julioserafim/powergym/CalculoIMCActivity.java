package com.example.julioserafim.powergym;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculoIMCActivity extends AppCompatActivity {
    private EditText altura;
    private EditText peso;
    private TextView resultadoEdit;
    private Handler handler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

    }

    public void calcularIMC(View view) {

                double resultado;
                double alturaValor;
                double pesoValor;

                altura = (EditText) findViewById(R.id.editTextAltura);
                peso = (EditText) findViewById(R.id.editTextPeso);
                resultadoEdit = (TextView) findViewById(R.id.textViewResultado);


                alturaValor = Double.parseDouble(altura.getText().toString());
                pesoValor = Double.parseDouble(peso.getText().toString());


                resultado = pesoValor / (alturaValor * alturaValor);
                resultadoEdit.setText("" + resultado);

                mudarFotoDeAcordoResultado(resultado);

    }



    public void mudarFotoDeAcordoResultado(final double resultado){
        new Thread(){
            public void run(){
                try {

                    if(resultado < 18.5 || resultado > 24.9 ){
                        URL url = new URL("http://tlc.matc.edu/wp-content/uploads/2014/04/warning-flat-icon.png");
                        HttpURLConnection connection;
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setDoInput(true);
                        connection.connect();
                        InputStream input = connection.getInputStream();
                        final Bitmap imagem = BitmapFactory.decodeStream(input);

                        final ImageView iv = (ImageView) findViewById(R.id.imageViewImc);

                        Log.i("OOOOLLALALALALAL", "OAOOAOAOAOAOA");

                        handler.post(new Runnable(){
                            public void run(){
                                iv.setImageBitmap(imagem);
                            }
                        });
                    }
                    else{
                        URL url = new URL("http://www.iconsdb.com/icons/preview/green/checked-checkbox-xxl.png");
                        HttpURLConnection connection;
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setDoInput(true);
                        connection.connect();
                        InputStream input = connection.getInputStream();
                        final Bitmap imagem = BitmapFactory.decodeStream(input);

                        final ImageView iv = (ImageView) findViewById(R.id.imageViewImc);


                        Log.i("OOOOLLALALALALAL", "OAOOAOAOAOAOA2");

                        handler.post(new Runnable(){
                            public void run(){
                                iv.setImageBitmap(imagem);
                            }
                        });
                    }

                }
                catch(MalformedURLException e) {
                    e.printStackTrace();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
