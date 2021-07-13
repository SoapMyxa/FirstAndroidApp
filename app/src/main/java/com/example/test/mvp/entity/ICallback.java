package com.example.test.mvp.entity;

import retrofit2.Response;

public interface ICallback<T> {

    void onLoad (Response<T> response);
    void onError (Throwable error);

}
