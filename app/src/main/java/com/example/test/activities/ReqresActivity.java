package com.example.test.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.retrofit.interceptors.LogRequest;
import com.example.test.retrofit.reqres.RequestService;
import com.example.test.retrofit.reqres.post.parsed.entities.RegistryLoginError;
import com.example.test.retrofit.reqres.post.parsed.entities.User;
import com.example.test.retrofit.reqres.post.parsed.entities.Credentials;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReqresActivity extends AppCompatActivity {

    Retrofit retrofit;
    RequestService requestService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reqres);

        // Кнопки для PUT запросов
        TextView getUsersList = findViewById(R.id.reqres_activity_get_users_list);
        TextView getSingleUser = findViewById(R.id.reqres_activity_get_single_user);
        TextView getSingleUserErr = findViewById(R.id.reqres_activity_get_single_user_err);
        TextView getResourcesList = findViewById(R.id.reqres_activity_get_resources_list);
        TextView getSingleResource = findViewById(R.id.reqres_activity_get_single_resource);
        TextView getSingleResourceErr = findViewById(R.id.reqres_activity_get_single_resource_err);
        TextView getUsersListDelayed = findViewById(R.id.reqres_activity_get_users_list_delay);

        // Кнопки для остальных запросов
        TextView postCreateUser = findViewById(R.id.reqres_activity_post_create_user);
        TextView putUpdateUser = findViewById(R.id.reqres_activity_post_update_user);
        TextView patchUpdateUser = findViewById(R.id.reqres_activity_patch_update_user);
        TextView deleteUser = findViewById(R.id.reqres_activity_delete);
        TextView postRegisterOk = findViewById(R.id.reqres_activity_register_ok);
        TextView postRegisterErr = findViewById(R.id.reqres_activity_register_err);
        TextView postLoginOk = findViewById(R.id.reqres_activity_login_ok);
        TextView postLoginErr = findViewById(R.id.reqres_activity_login_err);

        initializeRetrofit();

        initializeGetButtons(getUsersList, getSingleUser, getSingleUserErr, getResourcesList, getSingleResource, getSingleResourceErr, getUsersListDelayed);

        initializePostButtons(postCreateUser, putUpdateUser, patchUpdateUser, deleteUser, postRegisterOk, postRegisterErr, postLoginOk, postLoginErr);


    }

    /**
     * Инициализация кнопок столбца POST
     * @param postCreateUser  - кнопка Create
     * @param putUpdateUser   - кнопка PUT Update
     * @param patchUpdateUser - кнопка PATCH Update
     * @param deleteUser      - кнопка Delete
     * @param postRegisterOk  - кнопка Register Successful
     * @param postRegisterErr - кнопка Register Unsuccessful
     * @param postLoginOk     - кнопка Login Successful
     * @param postLoginErr    - кнопка Login Unsuccessful
     */
    private void initializePostButtons(TextView postCreateUser, TextView putUpdateUser, TextView patchUpdateUser, TextView deleteUser, TextView postRegisterOk, TextView postRegisterErr, TextView postLoginOk, TextView postLoginErr) {
        //CREATE
        postCreateUser.setOnClickListener(v -> requestService.createUser(new User("morpheus", "leader")).enqueue(getCallback("RQ_POST_CREATE_USER")));

        // обший пользователь для put update и patch update
        User userForUpdate = new User("morpheus", "zion resident");

        //PUT UPDATE
        putUpdateUser.setOnClickListener(v -> requestService.updateUser(2, userForUpdate).enqueue(getCallback("RQ_PUT_UPDATE_USER")));

        //PATCH UPDATE
        patchUpdateUser.setOnClickListener(v -> requestService.patchUser(2, userForUpdate).enqueue(getCallback("RQ_PATCH_UPDATE_USER")));

        //DELETE
        deleteUser.setOnClickListener(v -> requestService.deleteUser(2).enqueue(getCallback("RQ_DELETE_USER")));

        //POST REGISTER - SUCCESSFUL
        postRegisterOk.setOnClickListener(v -> requestService.registerUser(new Credentials("eve.holt@reqres.in",
                "pistol")).enqueue(getCallback("RQ_POST_REGISTRATE_USER")));

        //POST REGISTER - UNSUCCESSFUL
        postRegisterErr.setOnClickListener(v -> requestService.registerUser(new Credentials("sydney@fife", null)).enqueue(getCallback("RQ_POST_REGISTRATE_USER_ERR")));

        //POST LOGIN - SUCCESSFUL
        postLoginOk.setOnClickListener(v -> requestService.loginUser(new Credentials("eve.holt@reqres.in", "cityslicka")).enqueue(getCallback("RQ_POST_LOGIN_USER")));

        //POST LOGIN - SUCCESSFUL
        postLoginErr.setOnClickListener(v -> requestService.loginUser(new Credentials("sydney@fife", null)).enqueue(getCallback("RQ_POST_LOGIN_USER_ERR")));
    }

    /**
     * Инициализация кнопок столбца GET
     * @param getUsersList          - кнопка List users
     * @param getSingleUser         - кнопка Single user
     * @param getSingleUserErr      - кнопка Single user err
     * @param getResourcesList      - кнопка Resources list
     * @param getSingleResource     - кнопка Single resource
     * @param getSingleResourceErr  - кнопка Single resource err
     * @param getUsersListDelayed   - кнопка Delayed response
     */
    private void initializeGetButtons(TextView getUsersList
                                    , TextView getSingleUser
                                    , TextView getSingleUserErr
                                    , TextView getResourcesList
                                    , TextView getSingleResource
                                    , TextView getSingleResourceErr
                                    , TextView getUsersListDelayed)  {
        //LIST USERS
        getUsersList.setOnClickListener(v -> requestService.usersList(2).enqueue(getCallback("RQ_GET_LIST_USERS")));

        //SINGLE USER
        getSingleUser.setOnClickListener(v -> requestService.user(2).enqueue(getCallback("RQ_GET_SINGLE_USER")));

        //SINGLE USER NOT FOUND
        getSingleUserErr.setOnClickListener(v -> requestService.user(23).enqueue(getCallback("RQ_GET_SINGLE_USER_ERR")));

        //LIST <RESOURCES>
        getResourcesList.setOnClickListener(v -> requestService.resourcesList().enqueue(getCallback("RQ_GET_RESOURCES_LIST")));

        //SINGLE <RESOURCE>
        getSingleResource.setOnClickListener(v -> requestService.resource(2).enqueue(getCallback("RQ_GET_SINGLE_RESOURCE")));

        //SINGLE <RESOURCE> NOT FOUND
        getSingleResourceErr.setOnClickListener(v -> requestService.resource(23).enqueue(getCallback("RQ_GET_SINGLE_RESOURCE_ERR")));

        //GET DELAYED RESPONSE
        getUsersListDelayed.setOnClickListener(v -> requestService.usersList(3).enqueue(getCallback("RQ_GET_LIST_USERS_DELAY")));

    }

    /**
     * Инициализация Retrofit
     */
    private void initializeRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogRequest())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        requestService = retrofit.create(RequestService.class);
    }

    /**
     * ICallback для вызова
     * @param requestName - ключ для логирования
     * @param <T> - тип возвращаемого объекта (смотри пакеты retrofit.reqres.requested)
     * @return запрос после обработки
     */
    private <T> Callback<T> getCallback(String requestName) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {

                // удаление - код 204
                if (response.code() == 204){
                    Log.d(requestName, "Объект удален");
                }
                // Not found - 404
                else if (response.code() == 404){
                    Log.d(requestName, "Сервис не доступен (404)");
                }
                // запрос прошел успешно
                else if (response.isSuccessful()) {
                    Log.d(requestName, response.body().toString());

                }
                // ошибка авторизации
                else {

                    RegistryLoginError registryLoginErrorResponse =  null;

                    // ошибку нужно спарсить из JSON в POJO
                    Converter<ResponseBody, RegistryLoginError> converter
                            = retrofit.responseBodyConverter(RegistryLoginError.class, new Annotation[0]);
                    try {
                        registryLoginErrorResponse = converter.convert(response.errorBody());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Log.d(requestName, "Ошибка " + response.code() + " " + registryLoginErrorResponse.toString());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.d(requestName, t.getMessage());
            }
        };
    }

}