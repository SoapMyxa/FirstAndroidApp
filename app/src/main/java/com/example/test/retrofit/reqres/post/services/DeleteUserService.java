package com.example.test.retrofit.reqres.post.services;

import com.example.test.retrofit.reqres.post.parsed.entities.User;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

@FunctionalInterface
public interface DeleteUserService {

    /**
     * https://reqres.in/api/users/2
     *
     * Делетит пользователя. Возвращает код 204
     *
     * @param id - идентификатор пользователя
     * @return - статус 204
     */
    @DELETE("users/{id}")
    Call<User> deleteUser(@Path("id") Integer id);

}
