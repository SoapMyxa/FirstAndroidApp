package com.example.test.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.realm.Word;

import io.realm.Realm;

public class DictionaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        Realm realm = Realm.getDefaultInstance();

        RecyclerView recyclerView = findViewById(R.id.dictionary_activity_recycler_view);

        TextView goHomeButton = findViewById(R.id.dictionary_activity_home_btn);

                /*new RecyclerView(this.getApplicationContext());
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this.getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(
                this.getApplicationContext(),
                DividerItemDecoration.VERTICAL));*/
// create an adapter with a RealmResults collection
// and attach it to the RecyclerView
        recyclerView.setLayoutManager(
                new GridLayoutManager(this.getApplicationContext(), 1));

        RecyclerViewAdapterWord adapter =
                new RecyclerViewAdapterWord(this.getApplicationContext(),
                        realm.where(Word.class).findAll());
        recyclerView.setAdapter(adapter);

      /*  ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        this.addContentView(recyclerView, layoutParams);*/

        goHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}