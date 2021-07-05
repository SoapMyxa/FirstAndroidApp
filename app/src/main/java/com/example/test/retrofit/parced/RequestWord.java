package com.example.test.retrofit.parced;

/**
 * Сущность - слово
 *
 * Поля - слово, значение, произношение
 * Service - RandomWordService
 *
 */
public class RequestWord {

    private String word;
    private String definition;
    private String pronunciation;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }
}
