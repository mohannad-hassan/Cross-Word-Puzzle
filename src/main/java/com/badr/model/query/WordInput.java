package com.badr.model.query;

import java.util.List;

/**
 * Encapsulates a query about a word in a cross-word puzzle.
 * Created by mohannadhassan on 8/14/16.
 */
public class WordInput {

    private int wordLength;
    private List<CharacterInput> characterInputs;

    public WordInput(int wordLength, List<CharacterInput> characterInputs) {
        if (wordLength < 1) {
            throw new IllegalArgumentException("length may not be less than 1");
        }
        if (characterInputs == null) {
            throw new IllegalArgumentException("characterInputs may not be null");
        }

        this.wordLength = wordLength;
        this.characterInputs = characterInputs;
    }

    public int getWordLength() {
        return wordLength;
    }

    public List<CharacterInput> getCharacterInputs() {
        return characterInputs;
    }
}
