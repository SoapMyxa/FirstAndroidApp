package com.example.test.retrofit.reqres.post.parsed.entities;

import java.util.Date;

/**
 * Сущность User
 */
public class User {

    private String name;
    private String job;
    private String id;
    private Date createdAt;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id='" + id + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
