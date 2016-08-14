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
