package com.example.test.retrofit.reqres.get.parsed.requested;

import com.example.test.retrofit.reqres.get.parsed.entities.Support;
import com.example.test.retrofit.reqres.get.parsed.entities.User;

import java.util.List;

/**
 * Класс для JSON, возвращаемого из сервиса ListUsersService
 */

public class UsersList {

    private int page;

    @Override
    public String toString() {
        return "UsersList{" +
                "page=" + page +
                ", per_page=" + per_page +
                ", total=" + total +
                ", total_pages=" + total_pages +
                ", data=" + data +
                ", support=" + support +
                '}';
    }

    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data;
    private Support support;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
