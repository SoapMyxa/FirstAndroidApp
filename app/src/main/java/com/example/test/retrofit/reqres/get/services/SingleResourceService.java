package com.example.test.retrofit.reqres.get.services;

import com.example.test.retrofit.reqres.get.parsed.requested.SingleResource;
import com.example.test.retrofit.reqres.get.parsed.requested.SingleUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@FunctionalInterface
public interface SingleResourceService {

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

}
