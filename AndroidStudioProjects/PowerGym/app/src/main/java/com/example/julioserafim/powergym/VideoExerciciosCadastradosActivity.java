package com.example.julioserafim.powergym;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoExerciciosCadastradosActivity extends AppCompatActivity {
    private TextView downloadStatus;
    public static final String VIDEO = "video";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();

        setContentView(R.layout.activity_video_exercicios_cadastrados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setarVideo(i);

        downloadStatus = (TextView) findViewById(R.id.textViewStatusDownload);
        Button btnDownload = (Button) findViewById(R.id.buttonDownloadService);
        btnDownload.setOnClickListener(onDownloadListener());
    }

    public void setarVideo(Intent intent){
       long id = 0;
        long valor;
       valor = intent.getLongExtra(VideoExerciciosCadastradosActivity.VIDEO,id);

        if(valor == 0){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.supinoreto;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();
        }

        if(valor == 1){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.supinodeclinado;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();
        }

        if(valor == 2){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.extensaojoelhos;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();
        }

        if(valor == 3){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.agachamento;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();
        }

        if(valor == 4){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.puxadafrente;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();
        }

        if(valor == 5){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.roscadireta;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();
        }

        if(valor == 6){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.pegadatriceps;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();
        }

        if(valor == 7){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.remada;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();
        }

        if(valor == 8){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.flexaopernas;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();
        }

        if(valor == 9){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.abdominal;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();
        }

    }

    private View.OnClickListener onDownloadListener() {
        return new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                Intent intent1 = getIntent();
                int id = 0;
                long valor;
                valor = intent1.getLongExtra(VideoExerciciosCadastradosActivity.VIDEO,id);


                if(valor == 0){
                    Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                    intent.putExtra(DownloadFileService.NOMEARQUIVO, "supinoreto.mp3");
                    intent.putExtra(DownloadFileService.URL, "http://sv48.onlinevideoconverter.com/download?file=d3f5e4j9d3g6d3h7b1"); //"http://i.imgur.com/cReBvDB.png"

                    startService(intent);
                    downloadStatus.setText("Downloading...");
                }

                if(valor == 1){
                    Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                    intent.putExtra(DownloadFileService.NOMEARQUIVO, "supinodeclinado.mp3");
                    intent.putExtra(DownloadFileService.URL, "http://sv89.onlinevideoconverter.com/download?file=f5j9i8j9i8j9j9c2"); //"http://i.imgur.com/cReBvDB.png"

                    startService(intent);
                    downloadStatus.setText("Downloading...");
                }

                if(valor == 2){
                    Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                    intent.putExtra(DownloadFileService.NOMEARQUIVO, "algo.mp3");
                    intent.putExtra(DownloadFileService.URL, "http://sv46.onlinevideoconverter.com/download?file=g6b1a0c2j9b1d3g6b1"); //"http://i.imgur.com/cReBvDB.png"

                    startService(intent);
                    downloadStatus.setText("Downloading...");
                }

                if(valor == 3){
                    Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                    intent.putExtra(DownloadFileService.NOMEARQUIVO, "outroalgo.mp3");
                    intent.putExtra(DownloadFileService.URL, "http://sv38.onlinevideoconverter.com/download?file=g6c2j9j9h7f5h7e4b1"); //"http://i.imgur.com/cReBvDB.png"

                    startService(intent);
                    downloadStatus.setText("Downloading...");
                }

                if(valor == 4){
                    Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                    intent.putExtra(DownloadFileService.NOMEARQUIVO, "K.mp3");
                    intent.putExtra(DownloadFileService.URL, "http://sv14.onlinevideoconverter.com/download?file=a0f5f5a0g6e4a0h7b1"); //"http://i.imgur.com/cReBvDB.png"

                    startService(intent);
                    downloadStatus.setText("Downloading...");
                }

                if(valor == 5){
                    Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                    intent.putExtra(DownloadFileService.NOMEARQUIVO, "K.mp3");
                    intent.putExtra(DownloadFileService.URL, "http://sv76.onlinevideoconverter.com/download?file=j9h7g6f5f5i8g6e4"); //"http://i.imgur.com/cReBvDB.png"

                    startService(intent);
                    downloadStatus.setText("Downloading...");
                }

                if(valor == 6){
                    Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                    intent.putExtra(DownloadFileService.NOMEARQUIVO, "K.mp3");
                    intent.putExtra(DownloadFileService.URL, "http://sv76.onlinevideoconverter.com/download?file=j9h7g6f5f5i8g6e4"); //"http://i.imgur.com/cReBvDB.png"

                    startService(intent);
                    downloadStatus.setText("Downloading...");
                }

                if(valor == 7){
                    Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                    intent.putExtra(DownloadFileService.NOMEARQUIVO, "K.mp3");
                    intent.putExtra(DownloadFileService.URL, "http://sv76.onlinevideoconverter.com/download?file=j9h7g6f5f5i8g6e4"); //"http://i.imgur.com/cReBvDB.png"

                    startService(intent);
                    downloadStatus.setText("Downloading...");
                }

                if(valor == 8){
                    Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                    intent.putExtra(DownloadFileService.NOMEARQUIVO, "K.mp3");
                    intent.putExtra(DownloadFileService.URL, "http://sv76.onlinevideoconverter.com/download?file=j9h7g6f5f5i8g6e4"); //"http://i.imgur.com/cReBvDB.png"

                    startService(intent);
                    downloadStatus.setText("Downloading...");
                }

                if(valor == 9) {
                    Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                    intent.putExtra(DownloadFileService.NOMEARQUIVO, "K.mp3");
                    intent.putExtra(DownloadFileService.URL, "http://sv76.onlinevideoconverter.com/download?file=j9h7g6f5f5i8g6e4"); //"http://i.imgur.com/cReBvDB.png"

                    startService(intent);
                    downloadStatus.setText("Downloading...");

                }


                Toast.makeText(VideoExerciciosCadastradosActivity.this, "OLA" + valor, Toast.LENGTH_SHORT).show();

            }
        };
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


    public void voltarParaHome(View view){
        Intent i = new Intent(this,TelaInicialActivity.class);
        startActivity(i);
    }



    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(DownloadFileService.NOTIFICATION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                int tipoResultado = bundle.getInt(DownloadFileService.RESULTADO);

                if (tipoResultado == RESULT_OK) {
                    Toast.makeText(VideoExerciciosCadastradosActivity.this, "Arquivo Baixado com sucesso!", Toast.LENGTH_LONG).show();
                    downloadStatus.setText("Download completed!");
                } else {
                    Toast.makeText(VideoExerciciosCadastradosActivity.this, "Erro Download Arquivo!", Toast.LENGTH_LONG).show();
                    downloadStatus.setText("Download failed!");
                }
            }
        }
    };
}
