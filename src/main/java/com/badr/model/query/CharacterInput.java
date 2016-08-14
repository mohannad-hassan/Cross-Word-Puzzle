package com.badr.model.query;

/**
 * Encapsulates a query about one character in a word.
 * Created by mohannadhassan on 8/14/16.
 */
public class CharacterInput {

    private int position;
    private char character;

    public CharacterInput(int position, char character) {
        this.position = position;
        this.character = character;
    }

    public int getPosition() {
        return position;
    }

    public char getCharacter() {
        return character;
    }
}
