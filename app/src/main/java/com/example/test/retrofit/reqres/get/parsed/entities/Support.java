package com.example.test.retrofit.reqres.get.parsed.entities;

/**
 * Сущность Support
 * Добавочная информация в GET запросах
 *
 */
public class Support {

    private String url;
    private String text;

    @Override
    public String toString() {
        return "Support{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
