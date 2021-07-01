package com.example.test.retrofit.reqres.get.services;

import com.example.test.retrofit.reqres.get.parsed.requested.SingleUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@FunctionalInterface
public interface SingleResourceService {

    /**
     * https://reqres.in/api/users/2
     * возвращает JSON с одним пользователем
     *
     * {
     *     "data": {
     *         "id": 2,
     *         "email": "janet.weaver@reqres.in",
     *         "first_name": "Janet",
     *         "last_name": "Weaver",
     *         "avatar": "https://reqres.in/img/faces/2-image.jpg"
     *     },
     *     "support": {
     *         "url": "https://reqres.in/#support-heading",
     *         "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
     *     }
     * }
     *
     */
    @GET("users/{id}")
    Call<SingleUser> resource(@Path("id") Integer page);

}
