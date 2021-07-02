package com.example.test.retrofit.reqres.post.parsed.requested;

/**
 * Вход пользователя
 * Service: UserLoginService
 */
public class UserLogin {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "token='" + token + '\'' +
                '}';
    }
}
