package com.example.test.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.test.R;

import com.example.test.mvp.presentation.RandomWordActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView randWordButton = findViewById(R.id.main_activity_random_word_btn);
        TextView dictionaryButton = findViewById(R.id.main_activity_dictionary_btn);

        randWordButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, RandomWordActivity.class);
            startActivity(intent);
        });

        dictionaryButton.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, DictionaryActivity.class);
            startActivity(intent2);
        });
    }



}