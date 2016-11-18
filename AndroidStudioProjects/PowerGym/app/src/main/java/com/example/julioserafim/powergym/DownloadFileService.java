package com.example.julioserafim.powergym;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by julioserafim on 11/9/16.
 */
public class DownloadFileService extends IntentService {

    public static final String URL = "url";
    public static final String NOMEARQUIVO = "nome";
    public static final String CAMINHOARQUIVO = "caminho";
    public static final String RESULTADO = "resultado";
    public static final String NOTIFICATION = "notification";

    public DownloadFileService() {
        super("DownloadFileService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String urlPath = intent.getStringExtra(URL);
        String nomeArquivo = intent.getStringExtra(NOMEARQUIVO);
        int result = Activity.RESULT_CANCELED;
        //Log.d("TAG","NOVO07");


        try {
            //Log.d("TAG","JULIO AQUI");

            URL url = new URL(urlPath);
            InputStream input = url.openStream();
            File caminhoArmazenamento = new File(Environment.getExternalStorageDirectory() + "/Pictures");
            OutputStream output = new FileOutputStream(new File(caminhoArmazenamento, nomeArquivo));


            try {
                //Log.d("TAG","NOVO09");

                byte[] buffer = new byte[1024];
                int bytesRead = 0;
                while ((bytesRead = input.read(buffer, 0, buffer.length)) >= 0) {
                    output.write(buffer, 0, bytesRead);
                }
                result = Activity.RESULT_OK;
                Log.d("TAG","NOVO1");

            } finally {
                output.close();
                input.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Log.d("TAG","NOVOO2");


        dispararEventoMensagem(result);
    }

    private void dispararEventoMensagem(int result) {
        //Log.d("TAG","NOVO3");
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(RESULTADO, result);
        sendBroadcast(intent);
    }


}