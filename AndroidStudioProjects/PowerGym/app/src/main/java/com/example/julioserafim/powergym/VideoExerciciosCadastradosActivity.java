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

        //downloadStatus = (TextView) findViewById(R.id.textViewStatusDownload);
    }

    public void setarVideo(Intent intent){
       long id = 0;
        long valor;
       valor = intent.getLongExtra(VideoExerciciosCadastradosActivity.VIDEO,id);

        if(valor == 0){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.supinodeclinado;
            //Uri uri = Uri.parse("rtsp://r10---sn-q4f7snsk.googlevideo.com/Cj0LENy73wIaNAltcAyvi-QbchMYDSANFC0HqBNYMOCoAUIASARglpiTxvWE6OJXigELS2xRbGZYWmt3Y2cM/1D6B2AB9A3862375946F40058406029885BEDD3F.4237D411F14D8044E4FD47D6ABB2E5193B10EBDF/yt6/1/video.3gp");
            video.setMediaController(mediaController);
            video.setVideoURI(Uri.parse(path));
            video.start();


        }

        if(valor == 1){
            VideoView video = (VideoView)findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(this);
            //mediaController.setAnchorView(video);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.supinoreto;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tela_video_cadastrados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int idMenu = item.getItemId();


        if (idMenu == R.id.tela_inicial) {
            Intent i = new Intent(this,TelaInicialActivity.class);
            startActivity(i);

            return true;
        }

        if (idMenu == R.id.downloadMp3) {

            Intent intent1 = getIntent();
            int id = 0;
            long valor;
            valor = intent1.getLongExtra(VideoExerciciosCadastradosActivity.VIDEO,id);


            if(valor == 0){
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "supinodeclinado.mp3");
                intent.putExtra(DownloadFileService.URL, "https://volafile.io/get/doWyPvSZw64LC/supinodeclinado.mp3");//"https://doc-04-90-docs.googleusercontent.com/docs/securesc/ha0ro937gcuc7l7deffksulhg5h7mbp1/12hf8fqkktsgf4fu9iva1vsdms7sj3dh/1480550400000/12151624098411943033/*/0B0koGbSLPSj3T1RsdHIzNWJpZk0?e=download"); //"http://i.imgur.com/cReBvDB.png"
                startService(intent);
                Toast.makeText(this, "Baixando...", Toast.LENGTH_SHORT).show();

                //downloadStatus.setText("Downloading...");
            }

            if(valor == 1){
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "supinoreto.mp3");
                intent.putExtra(DownloadFileService.URL, "https://dl4.volafile.net/get/FMdjPv6Zw67QC/supinoreto.mp3");//"https://doc-04-90-docs.googleusercontent.com/docs/securesc/ha0ro937gcuc7l7deffksulhg5h7mbp1/12hf8fqkktsgf4fu9iva1vsdms7sj3dh/1480550400000/12151624098411943033/*/0B0koGbSLPSj3T1RsdHIzNWJpZk0?e=download"); //"http://i.imgur.com/cReBvDB.png"

                startService(intent);
                Toast.makeText(this, "Baixando...", Toast.LENGTH_SHORT).show();

                //downloadStatus.setText("Downloading...");
            }

            if(valor == 2){
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "extensaojoelhos.mp3");
                intent.putExtra(DownloadFileService.URL, "http://mboxmp3.com/u/extensaojoelhos.mp3");//"https://doc-0g-90-docs.googleusercontent.com/docs/securesc/ha0ro937gcuc7l7deffksulhg5h7mbp1/ulhgm9676rl80ojihqou1bb7q1j43nro/1480521600000/12151624098411943033/*/0B0koGbSLPSj3MVV2Rm04QXkyWjQ?e=download"); //"http://i.imgur.com/cReBvDB.png"

                startService(intent);
                Toast.makeText(this, "Baixando...", Toast.LENGTH_SHORT).show();

                //downloadStatus.setText("Downloading...");
            }

            if(valor == 3){
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "agachamento.mp3");
                intent.putExtra(DownloadFileService.URL, "http://mboxmp3.com/u/agachamento.mp3");//"https://doc-0k-90-docs.googleusercontent.com/docs/securesc/ha0ro937gcuc7l7deffksulhg5h7mbp1/ittatm0ai1tgjb2q20en8rnbtl1g5tc5/1480521600000/12151624098411943033/*/0B0koGbSLPSj3bWJGNEdjdmE3VEE?e=download"); //"http://i.imgur.com/cReBvDB.png"

                startService(intent);
                Toast.makeText(this, "Baixando...", Toast.LENGTH_SHORT).show();

                //downloadStatus.setText("Downloading...");
            }

            if(valor == 4){
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "puxadafrente.mp3");
                intent.putExtra(DownloadFileService.URL,"http://mboxmp3.com/u/puxadafrente.mp3");//"https://doc-10-90-docs.googleusercontent.com/docs/securesc/ha0ro937gcuc7l7deffksulhg5h7mbp1/unpoj877pv6fa99dalm7ivi8tvonrsj5/1480521600000/12151624098411943033/*/0B0koGbSLPSj3WWY3TWNqWGpZRFE?e=download"); //"http://i.imgur.com/cReBvDB.png"

                startService(intent);
                Toast.makeText(this, "Baixando...", Toast.LENGTH_SHORT).show();

                //downloadStatus.setText("Downloading...");
            }

            if(valor == 5){
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "roscadireta.mp3");
                intent.putExtra(DownloadFileService.URL,"http://mboxmp3.com/u/roscadireta.mp3"); //"https://doc-14-90-docs.googleusercontent.com/docs/securesc/ha0ro937gcuc7l7deffksulhg5h7mbp1/p71t7gv6e0s91i8u9ul9q2pbsn0hj4jg/1480521600000/12151624098411943033/*/0B0koGbSLPSj3VWNCcTk3eWktTGc?e=download"); //"http://i.imgur.com/cReBvDB.png"

                startService(intent);
                Toast.makeText(this, "Baixando...", Toast.LENGTH_SHORT).show();

                //downloadStatus.setText("Downloading...");
            }

            if(valor == 6){
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "pegadatriceps.mp3");
                intent.putExtra(DownloadFileService.URL, "https://volafile.io/get/f_acPvqZw64kC/tricepsholdana.mp3");//"https://doc-10-90-docs.googleusercontent.com/docs/securesc/ha0ro937gcuc7l7deffksulhg5h7mbp1/9ivbagjn0tk86ld56ba9i8vo75hh1n7o/1480521600000/12151624098411943033/*/0B0koGbSLPSj3cDNRdG9JVm5naDg?e=download"); //"http://i.imgur.com/cReBvDB.png"

                startService(intent);
                Toast.makeText(this, "Baixando...", Toast.LENGTH_SHORT).show();

                //downloadStatus.setText("Downloading...");
            }

            if(valor == 7){
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "remada.mp3");
                intent.putExtra(DownloadFileService.URL, "http://mboxmp3.com/u/remada.mp3");//"https://doc-0c-90-docs.googleusercontent.com/docs/securesc/ha0ro937gcuc7l7deffksulhg5h7mbp1/pc56fu91tgn9pm8231v094m7cbij94jo/1480521600000/12151624098411943033/*/0B0koGbSLPSj3R2VzNFFDVGlYbTg?e=download"); //"http://i.imgur.com/cReBvDB.png"

                startService(intent);
                Toast.makeText(this, "Baixando...", Toast.LENGTH_SHORT).show();

                //downloadStatus.setText("Downloading...");
            }

            if(valor == 8){
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "flexaopernas.mp3");
                intent.putExtra(DownloadFileService.URL,"https://volafile.io/get/G3NZP_6Zw67cC/flexaopernas.mp3"); //"https://doc-0g-90-docs.googleusercontent.com/docs/securesc/ha0ro937gcuc7l7deffksulhg5h7mbp1/fio6b0nqm6vo5g8b633okos510ogc479/1480521600000/12151624098411943033/*/0B0koGbSLPSj3Zk9jOHZKY1JfNms?e=download"); //"http://i.imgur.com/cReBvDB.png"

                startService(intent);
                Toast.makeText(this, "Baixando...", Toast.LENGTH_SHORT).show();

                //downloadStatus.setText("Downloading...");
            }

            if(valor == 9) {
                Intent intent = new Intent(VideoExerciciosCadastradosActivity.this, DownloadFileService.class);
                intent.putExtra(DownloadFileService.NOMEARQUIVO, "abdominal.mp3");
                intent.putExtra(DownloadFileService.URL,"https://volafile.io/get/WT4uP_qZw64pC/abdominal.mp3"); //"https://doc-00-90-docs.googleusercontent.com/docs/securesc/ha0ro937gcuc7l7deffksulhg5h7mbp1/prgk2fm0jhnbu11n5jaunibuged0e6jj/1480521600000/12151624098411943033/*/0B0koGbSLPSj3ZXloWVZCazUtdmM?e=download"); //"http://i.imgur.com/cReBvDB.png"

                startService(intent);
                Toast.makeText(this, "Baixando...", Toast.LENGTH_SHORT).show();

            }


            return true;
        }



        return super.onOptionsItemSelected(item);
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
                } else {
                    Toast.makeText(VideoExerciciosCadastradosActivity.this, "Erro Download Arquivo!", Toast.LENGTH_LONG).show();
                }
            }
        }
    };
}
