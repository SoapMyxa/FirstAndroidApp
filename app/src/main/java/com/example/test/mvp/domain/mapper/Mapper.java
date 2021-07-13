package com.example.test.mvp.domain.mapper;

public interface Mapper<From, To> {

    default To map(From item) {
        if(item == null) {
            throw new IllegalArgumentException("item is null");
        }

        return mapImpl(item);
    }

    To mapImpl(From item);

}
