package com.example.test.activities;

import androidx.appcompat.app.AppCompatActivity;

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
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RandomWordActivity extends AppCompatActivity {

    private TextView theWordView;
    private TextView skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_word);

        theWordView = findViewById(R.id.random_word_activity_the_word);
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

    private void addWordToDictionary(String newWord, String definition, String pronunciation) {
        Word word = new Word(newWord, definition, pronunciation);

        String realmName = "My Project";
        RealmConfiguration config = new RealmConfiguration.Builder().name(realmName).build();

        Realm backgroundThreadRealm = Realm.getInstance(config);

        backgroundThreadRealm.executeTransaction (transactionRealm -> {
            transactionRealm.insert(word);
        });
    }

    /**
     * Заполняет поле со случайным словом
     * @param theWord - случайное слово
     */
    private void fillTheWord(String theWord){
        this.theWordView.setText(theWord);
    }

    private void getRandomWordRequest(RandomWordService randomWordService){
        randomWordService.getRandomWord().enqueue(getCallback());
    }

    private Callback<List<RequestWord>> getCallback() {
        return new Callback<List<RequestWord>>() {
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