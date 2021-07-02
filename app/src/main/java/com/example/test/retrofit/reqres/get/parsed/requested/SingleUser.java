package com.example.test.retrofit.reqres.get.parsed.requested;

import com.example.test.retrofit.reqres.get.parsed.entities.Support;
import com.example.test.retrofit.reqres.get.parsed.entities.User;

/**
 * Результат запроса в виде одного User
 *
 * Service: SingleUserService
 *
 */
public class SingleUser {

    private User data;
    private Support support;

    @Override
    public String toString() {
        return "SingleUser{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
