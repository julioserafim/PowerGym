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
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoExerciciosCadastradosActivity extends AppCompatActivity {
    private TextView downloadStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_exercicios_cadastrados);

        VideoView video = (VideoView)findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        //mediaController.setAnchorView(video);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.supinoreto;
        //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
        video.setMediaController(mediaController);
        video.setVideoURI(Uri.parse(path));
        video.start();

        downloadStatus = (TextView) findViewById(R.id.textViewStatusDownload);
        Button btnDownload = (Button) findViewById(R.id.buttonDownloadService);
        btnDownload.setOnClickListener(onDownloadListener());
    }

    private View.OnClickListener onDownloadListener() {
        return new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "arquivo.mp3");
                intent.putExtra(DownloadFileService.URL, "http://audio.tatoeba.org/sentences/eng/953079.mp3"); //"http://i.imgur.com/cReBvDB.png"

                startService(intent);
                downloadStatus.setText("Downloading...");
            }
        };
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
