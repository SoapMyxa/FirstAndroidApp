package com.example.test.retrofit.services;

import com.example.test.retrofit.parced.Word;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RandomWordService {

    /**
     * https://random-words-api.vercel.app/word
     * возвращает JSON со случайным словом и его описанием
     *
     * [
     *   {
     *     "word": "Lac",
     *     "definition": "Dark red transparent resin used to make shellac  ",
     *     "pronunciation": "Lak"
     *   }
     * ]
     *
     */
    @GET("word")
    Call<List<Word>> getRandomWord(); //List - т.к. JSON возвращается в виде массива с одним словом

}
