package com.example.test.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.TagsForLog;
import com.example.test.retrofit.interceptors.LogRequest;
import com.example.test.retrofit.parced.Word;
import com.example.test.retrofit.services.RandomWordService;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RandomWordActivity extends AppCompatActivity {

    private TextView theWord;
    private TextView skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_word);

        theWord = findViewById(R.id.random_word_activity_the_word);
        skipButton = findViewById(R.id.random_word_activity_skip_btn);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogRequest())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://random-words-api.vercel.app/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RandomWordService randomWordService = retrofit.create(RandomWordService.class);

        getRandomWordRequest(randomWordService);

        skipButton.setOnClickListener(v -> getRandomWordRequest(randomWordService));

    }

    /**
     * Заполняет поле со случайным словом
     * @param theWord - случайное слово
     */
    private void fillTheWord(String theWord){
        this.theWord.setText(theWord);
    }

    private void getRandomWordRequest(RandomWordService randomWordService){
        randomWordService.getRandomWord().enqueue(getCallback());
    }

    private Callback<List<Word>> getCallback() {
        return new Callback<List<Word>>() {
            @Override
            public void onResponse(Call<List<Word>> call, Response<List<Word>> response) {

                // 0 - берем первый (и единственный) элемент JSONa
                String randWord = response.body().get(0).getWord();

                Log.d(TagsForLog.RANDOM_WORD_REQUEST_OK.toString(), randWord);

                fillTheWord(randWord);

            }

            @Override
            public void onFailure(Call<List<Word>> call, Throwable t) {
                Log.d(TagsForLog.RANDOM_WORD_REQUEST_FAIL.toString(), t.getMessage());
            }
        };
    }

}