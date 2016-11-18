package com.example.julioserafim.powergym.Config;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by julioserafim on 11/12/16.
 */
public class Configuracao extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration configuration = new RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(configuration);
    }
}
