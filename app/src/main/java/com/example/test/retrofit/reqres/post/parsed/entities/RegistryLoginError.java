package com.example.test.retrofit.reqres.post.parsed.entities;

/**
 * Ошибка при регистрации/логине пользователя
 * {
 *     "error": "Missing password"
 * }
 */

public class RegistryLoginError {
    private String error;

    @Override
    public String toString() {
        return "RegistryLoginError{" +
                "error='" + error + '\'' +
                '}';
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
