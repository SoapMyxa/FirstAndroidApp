package com.example.test.retrofit.reqres.post.parsed.requested;

/**
 * Результат регистрации нового пользователя
 * Service - RegistrationUserService
 */
public class NewUserRegistration {

    private String id;
    private String token;

    @Override
    public String toString() {
        return "NewUserRegistration{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public NewUserRegistration(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
