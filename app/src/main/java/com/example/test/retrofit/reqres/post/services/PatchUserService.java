package com.example.test.retrofit.reqres.post.services;

import com.example.test.retrofit.reqres.post.parsed.entities.User;
import com.example.test.retrofit.reqres.post.parsed.requested.UpdatedUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

@FunctionalInterface
public interface PatchUserService {

    /**
     * https://reqres.in/api/users/2
     *
     * Обновляет пользователя
     *
     * @param id - идентификатор пользователя
     * @param patch - новые данные
     *  {
     *  "name": "morpheus",
     *  "job": "zion resident"
     *  }
     * @return
     * {
     *     "name": "morpheus",
     *     "job": "zion resident",
     *     "updatedAt": "2021-07-02T10:31:28.951Z"
     * }
     */
    @PATCH("users/{id}")
    Call<UpdatedUser> patchUser(@Path("id") Integer id, @Body User patch);

}