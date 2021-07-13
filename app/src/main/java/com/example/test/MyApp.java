package com.example.test;

import android.app.Application;


import com.example.test.retrofit.interceptors.LogRequest;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.test.providers.realm.RealmInit;

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmInit.initializeRealm();
    }




}
