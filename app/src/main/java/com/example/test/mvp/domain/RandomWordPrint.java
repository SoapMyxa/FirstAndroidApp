package com.example.test.mvp.domain;

public class RandomWordPrint {

    private String randomWord;
    private String randomWordDefinition;

    public RandomWordPrint(String randomWord, String randomWordPronounce) {
        this.randomWord = randomWord;
        this.randomWordDefinition = randomWordPronounce;
    }

    public String getRandomWord() {
        return randomWord;
    }

    public void setRandomWord(String randomWord) {
        this.randomWord = randomWord;
    }

    public String getRandomWordDefinition() {
        return randomWordDefinition;
    }

    public void setRandomWordDefinition(String randomWordDefinition) {
        this.randomWordDefinition = randomWordDefinition;
    }
}
