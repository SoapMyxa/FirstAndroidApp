package com.example.test.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.TagsForLog;
import com.example.test.realm.Word;
import com.example.test.retrofit.interceptors.LogRequest;
import com.example.test.retrofit.parced.RequestWord;
import com.example.test.retrofit.services.RandomWordService;

import java.util.List;

import io.realm.Realm;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RandomWordActivity extends AppCompatActivity {

    private TextView theWordView;
    private final Realm realm = Realm.getDefaultInstance();
    private final String APIBaseUrl = "https://random-words-api.vercel.app/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_word);

        theWordView = findViewById(R.id.random_word_activity_the_word);

        waitForResponse();

        TextView skipButton = findViewById(R.id.random_word_activity_skip_btn);

        TextView goHomeButton = findViewById(R.id.random_activity_home_btn);

        Retrofit retrofit = initializeRetrofit();

        RandomWordService randomWordService = retrofit.create(RandomWordService.class);

        getRandomWordRequest(randomWordService);

        skipButton.setOnClickListener(v -> getRandomWordRequest(randomWordService));

        goHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }

    /**
     * Инициализация ретрофит
     * @return Retrofit
     */
    private Retrofit initializeRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogRequest())
                .build();

        return new Retrofit.Builder()
                .baseUrl(APIBaseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Подставляет строку ожидания, пока API отвечает
     */
    private void waitForResponse() {
        fillTheWord("Ищем слово...");
    }

    /**
     * Добавляет новое слово в словарь
     * @param newWord - случайное слово (непереведенное)
     * @param definition - значение слова
     * @param pronunciation - произношение
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void addWordToDictionary(String newWord, String definition, String pronunciation) {
        Word word = new Word(newWord, definition, pronunciation);

        realm.executeTransaction(transactionRealm -> {
                     transactionRealm.insert(word);
        });


    }

    /**
     * Заполняет поле со словом
     * @param theWord - случайное слово
     */
    private void fillTheWord(String theWord){
        this.theWordView.setText(theWord);
    }

    /**
     * Запрос к API для получения случайного слова
     * @param randomWordService - GET retrofit service
     */
    private void getRandomWordRequest(RandomWordService randomWordService){
        waitForResponse();
        randomWordService.getRandomWord().enqueue(getCallback());
    }

    /**
     * Срабатывает после того, как запрос к API вернулся
     * @return Callback
     */
    private Callback<List<RequestWord>> getCallback() {
        return new Callback<List<RequestWord>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<RequestWord>> call, Response<List<RequestWord>> response) {


                // 0 - берем первый (и единственный) элемент JSONa
                String randWord = response.body().get(0).getWord();
                String randWordDefinition = response.body().get(0).getDefinition();
                String randWordPronunciation = response.body().get(0).getPronunciation();

                Log.d(TagsForLog.RANDOM_WORD_REQUEST_OK.toString(), randWord);

                fillTheWord(randWord);
                addWordToDictionary(randWord, randWordDefinition, randWordPronunciation);

            }

            @Override
            public void onFailure(Call<List<RequestWord>> call, Throwable t) {
                Log.d(TagsForLog.RANDOM_WORD_REQUEST_FAIL.toString(), t.getMessage());
            }
        };
    }

}