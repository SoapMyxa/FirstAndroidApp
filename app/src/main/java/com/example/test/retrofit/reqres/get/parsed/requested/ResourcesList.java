package com.example.test.retrofit.reqres.get.parsed.requested;

import com.example.test.retrofit.reqres.get.parsed.entities.Support;
import com.example.test.retrofit.reqres.get.parsed.entities.Resource;

import java.util.List;

public class ResourcesList {

    private int per_page;
    private int total;
    private int total_pages;
    private List<Resource> data;
    private Support support;

    @Override
    public String toString() {
        return "ResourcesList{" +
                "per_page=" + per_page +
                ", total=" + total +
                ", total_pages=" + total_pages +
                ", data=" + data +
                ", support=" + support +
                '}';
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

    public List<Resource> getData() {
        return data;
    }

    public void setData(List<Resource> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
