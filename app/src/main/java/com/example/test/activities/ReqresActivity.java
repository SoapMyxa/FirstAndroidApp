package com.example.test.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.retrofit.interceptors.LogRequest;
import com.example.test.retrofit.reqres.get.services.ListResourcesService;
import com.example.test.retrofit.reqres.get.services.ListUsersService;
import com.example.test.retrofit.reqres.get.services.SingleResourceService;
import com.example.test.retrofit.reqres.get.services.SingleUserService;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReqresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reqres);

        TextView getUsersList = findViewById(R.id.reqres_activity_get_users_list);
        TextView getSingleUser = findViewById(R.id.reqres_activity_get_single_user);
        TextView getSingleUserErr = findViewById(R.id.reqres_activity_get_single_user_err);
        TextView getResourcesList = findViewById(R.id.reqres_activity_get_resources_list);
        TextView getSingleResource = findViewById(R.id.reqres_activity_get_single_resource);
        TextView getSingleResourceErr = findViewById(R.id.reqres_activity_get_single_resource_err);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogRequest())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ListUsersService listUsersService = retrofit.create(ListUsersService.class);
        SingleUserService singleUserService = retrofit.create(SingleUserService.class);

        ListResourcesService listResourcesService = retrofit.create(ListResourcesService.class);
        SingleResourceService singleResourceService = retrofit.create(SingleResourceService.class);

        //GET USERS
        getUsersList.setOnClickListener(v -> listUsersService.usersList(2).enqueue(getCallback("GET_LIST_USERS")));
        getSingleUser.setOnClickListener(v -> singleUserService.user(2).enqueue(getCallback("GET_SINGLE_USER")));
        getSingleUserErr.setOnClickListener(v -> singleUserService.user(23).enqueue(getCallback("GET_SINGLE_USER_ERR")));

        //GET RESOURCES
        getResourcesList.setOnClickListener(v -> listResourcesService.resourcesList().enqueue(getCallback("GET_RESOURCES_LIST")));
        getSingleResource.setOnClickListener(v -> singleResourceService.resource(2).enqueue(getCallback("GET_SINGLE_RESOURCE")));
        getSingleResourceErr.setOnClickListener(v -> singleResourceService.resource(23).enqueue(getCallback("GET_SINGLE_RESOURCE_ERR")));
    }

    private <T> Callback<T> getCallback(String requestName) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {

                if (response.isSuccessful()) {
                  Log.d(requestName, response.body().toString());
                }
                else {
                   Log.d(requestName, "Ошибка " + response.code());
                }

            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.d(requestName, t.getMessage());
            }
        };
    }

}