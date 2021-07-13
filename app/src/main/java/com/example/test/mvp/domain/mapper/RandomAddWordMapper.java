package com.example.test.mvp.domain.mapper;

import com.example.test.mvp.entity.RandomWordDto;
import com.example.test.realm.Word;

/**
 * Маппинг RandomWordDto в Realm'овский объект
 */
public class RandomAddWordMapper implements Mapper<RandomWordDto, Word> {

    @Override
    public Word mapImpl(RandomWordDto item) {
        return new Word(item.getWord(), item.getDefinition(), item.getPronunciation());
    }

}
