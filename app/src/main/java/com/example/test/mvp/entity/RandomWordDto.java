package com.example.test.mvp.entity;

/**
 * Сущность - слово
 *
 * Поля - слово, значение, произношение
 *
 */
public class RandomWordDto {

    private String word;
    private String definition;
    private String pronunciation;

    public RandomWordDto(String word, String definition, String pronunciation) {
        this.word = word;
        this.definition = definition;
        this.pronunciation = pronunciation;
    }

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
