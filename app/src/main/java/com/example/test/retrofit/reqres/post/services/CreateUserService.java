package com.example.test.retrofit.reqres.post.services;

import com.example.test.retrofit.reqres.post.parsed.entities.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@FunctionalInterface
public interface CreateUserService {

    /**
     * https://reqres.in/api/users
     * @param post - данные о пользователе
     * {
     *     "name": "morpheus",
     *     "job": "leader"
     * }
     * @return User - созданный пользователь
     *
     * {
     *     "name": "morpheus",
     *     "job": "leader",
     *     "id": "587",
     *     "createdAt": "2021-07-02T10:29:53.157Z"
     * }
     */
    @POST("users")
    Call<User> createUser(@Body User post);

}
