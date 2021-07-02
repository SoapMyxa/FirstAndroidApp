package com.example.test.retrofit.reqres.post.parsed.requested;

import com.example.test.retrofit.reqres.post.parsed.entities.User;

import java.util.Date;

/**
 * Обновление User
 *
 * Service - UpdateUserService, PatchUserService
 *
 */
public class UpdatedUser extends User {
    public UpdatedUser(String name, String job, Date updatedAt) {
        super(name, job);
        setUpdatedAt(updatedAt);
    }

    private Date updatedAt;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "UpdatedUser{" +
                "name='" + super.getName() + '\'' +
                "job='" + super.getJob() + '\'' +
                "updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
