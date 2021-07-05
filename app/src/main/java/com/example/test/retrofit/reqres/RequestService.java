package com.example.test.retrofit.reqres;

import com.example.test.retrofit.reqres.get.parsed.requested.ResourcesList;
import com.example.test.retrofit.reqres.get.parsed.requested.SingleResource;
import com.example.test.retrofit.reqres.get.parsed.requested.SingleUser;
import com.example.test.retrofit.reqres.get.parsed.requested.UsersList;
import com.example.test.retrofit.reqres.post.parsed.entities.Credentials;
import com.example.test.retrofit.reqres.post.parsed.entities.User;
import com.example.test.retrofit.reqres.post.parsed.requested.NewUserRegistration;
import com.example.test.retrofit.reqres.post.parsed.requested.UpdatedUser;
import com.example.test.retrofit.reqres.post.parsed.requested.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RequestService {

    /**
     * https://reqres.in/api/unknown
     * возвращает JSON со списком ресурсов
     * {
     *     "page": 1,
     *     "per_page": 6,
     *     "total": 12,
     *     "total_pages": 2,
     *     "data": [
     *         {
     *             "id": 1,
     *             "name": "cerulean",
     *             "year": 2000,
     *             "color": "#98B2D1",
     *             "pantone_value": "15-4020"
     *         },
     *         {
     *             "id": 2,
     *             "name": "fuchsia rose",
     *             "year": 2001,
     *             "color": "#C74375",
     *             "pantone_value": "17-2031"
     *         },
     *         {
     *             "id": 3,
     *             "name": "true red",
     *             "year": 2002,
     *             "color": "#BF1932",
     *             "pantone_value": "19-1664"
     *         },
     *         {
     *             "id": 4,
     *             "name": "aqua sky",
     *             "year": 2003,
     *             "color": "#7BC4C4",
     *             "pantone_value": "14-4811"
     *         },
     *         {
     *             "id": 5,
     *             "name": "tigerlily",
     *             "year": 2004,
     *             "color": "#E2583E",
     *             "pantone_value": "17-1456"
     *         },
     *         {
     *             "id": 6,
     *             "name": "blue turquoise",
     *             "year": 2005,
     *             "color": "#53B0AE",
     *             "pantone_value": "15-5217"
     *         }
     *     ],
     *     "support": {
     *         "url": "https://reqres.in/#support-heading",
     *         "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
     *     }
     * }
     *
     */
    @GET("resources")
    Call<ResourcesList> resourcesList();

    /**
     * https://reqres.in/api/users?page=2
     * возвращает JSON со списком пользователей
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
    Call<UsersList> usersList(@Query("page") Integer page);

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
    Call<UsersList> usersListDelay(@Query("delay") Integer delay);

    /**
     * https://reqres.in/api/unknown/2
     * возвращает JSON с одним ресурсом
     *
     * {
     *     "data": {
     *         "id": 2,
     *         "name": "fuchsia rose",
     *         "year": 2001,
     *         "color": "#C74375",
     *         "pantone_value": "17-2031"
     *     },
     *     "support": {
     *         "url": "https://reqres.in/#support-heading",
     *         "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
     *     }
     * }
     *
     */
    @GET("unknown/{page}")
    Call<SingleResource> resource(@Path("page") Integer page);

    /**
     * https://reqres.in/api/users/2
     * возвращает JSON с одним пользователем
     *
     * {
     *     "data": {
     *         "id": 2,
     *         "name": "fuchsia rose",
     *         "year": 2001,
     *         "color": "#C74375",
     *         "pantone_value": "17-2031"
     *     },
     *     "support": {
     *         "url": "https://reqres.in/#support-heading",
     *         "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
     *     }
     * }
     *
     */
    @GET("users/{id}")
    Call<SingleUser> user(@Path("id") Integer page);

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

    /**
     * https://reqres.in/api/users/2
     *
     * Обновляет пользователя
     *
     * @param id - идентификатор пользователя
     * @param put - новые данные
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
    @PUT("users/{id}")
    Call<UpdatedUser> updateUser(@Path("id") Integer id, @Body User put);

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
