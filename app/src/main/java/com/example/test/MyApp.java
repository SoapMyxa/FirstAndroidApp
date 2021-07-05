package com.example.test;

import android.app.Application;


import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApp extends Application {

    Realm uiThreadRealm;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        String realmName = "My Project";
        RealmConfiguration config = new RealmConfiguration.Builder().name(realmName).build();
        uiThreadRealm = Realm.getInstance(config);

    }

}
