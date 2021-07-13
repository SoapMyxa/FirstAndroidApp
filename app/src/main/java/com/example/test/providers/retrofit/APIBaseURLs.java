package com.example.test.providers.retrofit;

/**
 * BaseURL's для retrofit
 */
public enum APIBaseURLs {

    RANDOM_WORD_API("https://random-words-api.vercel.app/");


    private String APIBaseURL;

    APIBaseURLs(String APIBaseURL) {
        this.APIBaseURL = APIBaseURL;
    }

    @Override
    public String toString() {
        return APIBaseURL;
    }
}
