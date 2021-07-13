package com.example.test.providers.retrofit;

import com.example.test.retrofit.interceptors.LogRequest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public abstract class AbstractRetrofit {

    /**
     * Создание экземпляра Retrofit для указанного BaseURL
     * @param
     */
    Retrofit getInstance(String APIBaseURL) {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogRequest())
                .build();

        return new Retrofit.Builder()
                .baseUrl(APIBaseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
