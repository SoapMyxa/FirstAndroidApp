package com.example.test.mvp.domain.mapper;

import com.example.test.mvp.domain.RandomWordPrint;
import com.example.test.mvp.entity.RandomWordDto;

public class RandomGetWordMapper implements Mapper<RandomWordDto, RandomWordPrint> {

    @Override
    public RandomWordPrint mapImpl(RandomWordDto item) {
        return new RandomWordPrint(item.getWord(), item.getDefinition());
    }

}
