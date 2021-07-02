package com.example.test.retrofit.reqres.post.services;

import com.example.test.retrofit.reqres.post.parsed.entities.Credentials;
import com.example.test.retrofit.reqres.post.parsed.requested.NewUserRegistration;
import com.example.test.retrofit.reqres.post.parsed.requested.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@FunctionalInterface
public interface UserLoginService {

    /**
     * Вход пользователя
     *
     * https://reqres.in/api/login
     * @param post - учетные данные
     *
     * {
     *     "email": "eve.holt@reqres.in",
     *     "password": "pistol"
     * }
     * @return NewUserRegistration - результат входа
     *
     * {
     *     "id": 4,
     *     "token": "QpwL5tke4Pnpja7X4"
     * }
     */
    @POST("login")
    Call<UserLogin> loginUser(@Body Credentials post);

}
