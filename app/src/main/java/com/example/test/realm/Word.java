package com.example.test.realm;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Слово в словаре
 */
public class Word extends RealmObject {

    @Required private String word;
    @Required private String definition;
    @Required private String pronunciation;

    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, String definition, String pronunciation) {
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
