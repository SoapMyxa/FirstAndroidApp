package com.example.test.retrofit.reqres.get.parsed.requested;

import com.example.test.retrofit.reqres.get.parsed.entities.Resource;
import com.example.test.retrofit.reqres.get.parsed.entities.Support;

public class SingleResource {

    private Resource data;
    private Support support;

    @Override
    public String toString() {
        return "SingleResource{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }

    public Resource getData() {
        return data;
    }

    public void setData(Resource data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
