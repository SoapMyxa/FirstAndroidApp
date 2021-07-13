package com.example.test.mvp.entity;

import com.example.test.realm.Word;

import java.util.List;


public interface IRandomWordRepository {

    void loadRandomWord(ICallback<List<RandomWordDto>> callback);

    void addRandomWord(Word newRandomWord);

}
