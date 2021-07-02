package com.example.test.retrofit.reqres.get.services;

import com.example.test.retrofit.reqres.get.parsed.requested.UsersList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@FunctionalInterface
public interface ListUsersServiceDelay {

    /**
     * https://reqres.in/api/users?delay=3
     * возвращает JSON со списком пользователей с задержкой
     *
     * {
     *     "page": 2,
     *     "per_page": 6,
     *     "total": 12,
     *     "total_pages": 2,
     *     "data": [
     *         {
     *             "id": 7,
     *             "email": "michael.lawson@reqres.in",
     *             "first_name": "Michael",
     *             "last_name": "Lawson",
     *             "avatar": "https://reqres.in/img/faces/7-image.jpg"
     *         },
     *         {
     *             "id": 8,
     *             "email": "lindsay.ferguson@reqres.in",
     *             "first_name": "Lindsay",
     *             "last_name": "Ferguson",
     *             "avatar": "https://reqres.in/img/faces/8-image.jpg"
     *         },
     *         ...
     *     ],
     *     "support": {
     *         "url": "https://reqres.in/#support-heading",
     *         "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
     *     }
     * }
     *
     */
    @GET("users")
    Call<UsersList> usersList(@Query("delay") Integer delay);

}
