package com.example.test.retrofit.interceptors;

import android.util.Log;

import com.example.test.TagsForLog;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Перехватчик запросов
 * Логирует каждый запрос
 */
public class LogRequest implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        Log.d(TagsForLog.RQ_GET_REQUEST.toString(), request.toString());

        return chain.proceed(request);
    }
}
