package com.example.test.mvp.domain;

import com.example.test.mvp.domain.mapper.Mapper;
import com.example.test.mvp.domain.mapper.RandomAddWordMapper;
import com.example.test.mvp.entity.ICallback;
import com.example.test.mvp.entity.IRandomWordRepository;
import com.example.test.mvp.entity.RandomWordDto;
import com.example.test.realm.Word;

import java.util.List;


public class RandomWordModel {

    private final IRandomWordRepository repo;

    public RandomWordModel(IRandomWordRepository repo) {
        this.repo = repo;
    }

    public void get(ICallback<List<RandomWordDto>> callback) {
        repo.loadRandomWord(callback);
    }


    public void add(Word newRandomWord) {

        repo.addRandomWord(newRandomWord);
    }    

}
