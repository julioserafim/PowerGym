package com.example.julioserafim.powergym;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by julioserafim on 10/09/16.
 */
public class NotificarAcademiaService extends Service{
 private static final String ACADEMIA = "ACADEMIA";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String academiaProxima = intent.getStringExtra(ACADEMIA);
        Toast.makeText(NotificarAcademiaService.this, "Academia mais próxima:" + academiaProxima, Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }
}
