package com.example.test.providers.retrofit;

import retrofit2.Retrofit;

/**
 * Экземпляр retrofit для APIBaseURLs.RANDOM_WORD_API
 */
public final class RandomWordRetrofit extends AbstractRetrofit {

    private static RandomWordRetrofit instance;
    public Retrofit retrofit;

    private RandomWordRetrofit(){
        retrofit = super.getInstance(APIBaseURLs.RANDOM_WORD_API.toString());
    }

    public static RandomWordRetrofit getInstance(){
        if (instance == null) {
            instance = new RandomWordRetrofit();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
