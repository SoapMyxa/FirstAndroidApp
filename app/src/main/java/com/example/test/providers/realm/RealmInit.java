package com.example.test.providers.realm;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmInit {

    public static void initializeRealm() {

        String realmName = "My Project";
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .inMemory() // пока только в памяти, чтобы не захламлять
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .name(realmName)
                .build();
        Realm.setDefaultConfiguration(config);
    }

}
