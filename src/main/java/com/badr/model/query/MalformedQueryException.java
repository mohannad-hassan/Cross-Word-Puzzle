package com.badr.model.query;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class MalformedQueryException extends Exception {
    private char character;
    private String word;

    public char getCharacter() {
        return character;
    }

    public String getWord() {
        return word;
    }

    public MalformedQueryException(char character, String word) {
        super("Illegal character '" + character + "' in input \"" + word + "\"");
        this.character = character;
        this.word = word;
    }
}
