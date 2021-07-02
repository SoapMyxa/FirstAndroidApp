package com.example.test.retrofit.reqres.post.services;

import com.example.test.retrofit.reqres.post.parsed.entities.Credentials;
import com.example.test.retrofit.reqres.post.parsed.requested.NewUserRegistration;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@FunctionalInterface
public interface RegistrationUserService {

    /**
     * https://reqres.in/api/register
     * @param post - учетные данные
     *
     * {
     *     "email": "eve.holt@reqres.in",
     *     "password": "pistol"
     * }
     * @return NewUserRegistration - результат регистрации
     *
     * {
     *     "id": 4,
     *     "token": "QpwL5tke4Pnpja7X4"
     * }
     */
    @POST("register")
    Call<NewUserRegistration> registerUser(@Body Credentials post);

}
