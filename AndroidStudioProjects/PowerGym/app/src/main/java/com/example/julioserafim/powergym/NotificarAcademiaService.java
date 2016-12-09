package com.example.julioserafim.powergym;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by julioserafim on 10/09/16.
 */
public class NotificarAcademiaService extends IntentService {
 private static final String ACADEMIA = "ACADEMIA";


    public NotificarAcademiaService() {
        super("NotificarAcademiaService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        String academia = intent.getStringExtra("academia");
        Toast.makeText(this, "Academi mais próxima" + academia, Toast.LENGTH_SHORT).show();
    }



}
