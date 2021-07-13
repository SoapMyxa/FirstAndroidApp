package com.example.test.mvp.presentation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.TagsForLog;
import com.example.test.activities.MainActivity;
import com.example.test.mvp.domain.RandomWordModel;
import com.example.test.mvp.domain.RandomWordPrint;
import com.example.test.mvp.entity.RandomWordDto;
import com.example.test.mvp.entity.RandomWordRepo;
import com.example.test.realm.Word;
import com.example.test.retrofit.interceptors.LogRequest;
import com.example.test.retrofit.services.RandomWordService;

import java.util.List;

import io.realm.Realm;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RandomWordActivity extends AppCompatActivity implements RandomWordView {


    private RandomWordPresenter randomWordPresenter;

    private TextView theWordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_word);

        theWordView = findViewById(R.id.random_word_activity_the_word);
        TextView skipButton = findViewById(R.id.random_word_activity_skip_btn);

        randomWordPresenter = new RandomWordPresenter(this,
                                                       new RandomWordModel(new RandomWordRepo()));

        // событие на нажатие кнопки
        skipButton.setOnClickListener(v -> randomWordPresenter.onLoadRandomWord());

        // первичная загрузка случайного слова (при создании activity)
        randomWordPresenter.onLoadRandomWord();

        TextView goHomeButton = findViewById(R.id.random_activity_home_btn);
        goHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }


    /**
     * Подставляет строку ожидания, пока API отвечает
     */
    public void waitForResponse() {
        fillTheWord("Ищем слово...");
    }


    /**
     * Заполняет поле со словом
     * @param theWord - случайное слово
     */
    private void fillTheWord(String theWord){
        this.theWordView.setText(theWord);
    }

    /**
     * Обрабатывает полученное случайное слово
     * @param randomWordPrint
     */
    @Override
    public void showRandWord(RandomWordPrint randomWordPrint) {
        fillTheWord(randomWordPrint.getRandomWord());
    }
}