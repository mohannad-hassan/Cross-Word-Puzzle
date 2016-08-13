package com.badr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class MultiCharIndex {
    private int length;

    private List<AlphabetIndex> charactersIndexes;

    final int LONGEST_POSSIBLE_LENGTH = 45;

    public MultiCharIndex(int length, List<String> words) {
        if (length < 1 || length > LONGEST_POSSIBLE_LENGTH) {
            throw new IllegalArgumentException("Illegal value for length: " + length + ". length should be between " +
                    "1 and " + LONGEST_POSSIBLE_LENGTH);
        }
        if (words == null) {
            throw new IllegalArgumentException("words may not be null");
        }

        this.length = length;

        instantiateCharactersIndexes();
        populateWords(words);
    }

    private void instantiateCharactersIndexes() {
        charactersIndexes = new ArrayList<AlphabetIndex>(length);

        for (int i = 0; i < length; i++) {
            charactersIndexes.add(new AlphabetIndex());
        }
    }

    private void populateWords(List<String> words) {
        for (String word : words) {
            if (word.length() != length) {
                throw new IllegalArgumentException("Word \"" + word + "\" is not of the same length required for this " +
                        "index");
            }

            for (int i = 0; i < length; i++) {
                charactersIndexes.get(i).put(word.charAt(i), word);
            }
        }
    }

    private class AlphabetIndex {

        public void put(Character c, String word) {

        }
    }
}
