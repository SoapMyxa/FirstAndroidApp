package com.example.test.mvp.entity;


import com.example.test.providers.retrofit.RandomWordRetrofit;
import com.example.test.realm.Word;
import com.example.test.retrofit.services.RandomWordService;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RandomWordRepo implements IRandomWordRepository{


    /**
     * Загрузить случайное слово из API
     * @param callback - что сработает после загрузки
     */
    @Override
    public void loadRandomWord(ICallback<List<RandomWordDto>> callback) {
        Retrofit retrofitInstance = RandomWordRetrofit.getInstance().getRetrofit();

        RandomWordService randomWordService = retrofitInstance.create(RandomWordService.class);

        randomWordService.getRandomWord()
                         .enqueue(onResponseCallback(callback));

    }

    /**
     * Callback после срабатывания enqueue
     * @param callback - логика, срабатывающая после ответа API
     */
    private Callback<List<RandomWordDto>> onResponseCallback(ICallback<List<RandomWordDto>> callback) {
        return new Callback<List<RandomWordDto>>() {

            @Override
            public void onResponse(Call<List<RandomWordDto>> call, Response<List<RandomWordDto>> response) {
                callback.onLoad(response);
            }

            @Override
            public void onFailure(Call<List<RandomWordDto>> call, Throwable t) {

            }
        };
    }

    /**
     * Добавляет новое слово
     * @param newRandomWord
     */
    @Override
    public void addRandomWord(Word newRandomWord) {

        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(transactionRealm -> {
            transactionRealm.insert(newRandomWord);
        });
    }


}
