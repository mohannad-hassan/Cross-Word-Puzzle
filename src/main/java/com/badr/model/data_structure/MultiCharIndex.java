package com.badr.model.data_structure;

import com.badr.model.query.CharacterInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Indexes input words by characters per each position. Created to facilitate searching words of the same length for
 * input characters in some positions.
 * Created by mohannadhassan on 8/14/16.
 */
public class MultiCharIndex {
    private int length;

    private List<AlphabetIndex> charactersIndexes;

    public MultiCharIndex(int length, List<String> words) {
        if (length < 1) {
            throw new IllegalArgumentException("Illegal value for length: " + length + ". length should be non zero");
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

    public int getLength() {
        return length;
    }

    /**
     * Searches the index for words that match the input <code>characterInputs</code>.
     * @param characterInputs Describes given characters and their positions.
     * @return A set of words that match <code>characterInputs</code>
     * @throws IllegalArgumentException if given <code>characterInputs's</code> length exceeds <code>this.length</code>
     */
    public Set<String> search(List<CharacterInput> characterInputs) {
        if (characterInputs == null) {
            throw new IllegalArgumentException("characterInputs may not be null");
        }

        Set<String> result = null;

        for (CharacterInput input :
                characterInputs) {
            int pos = input.getPosition();
            if (pos > length) {
                throw new IllegalArgumentException("CharacterInput has a position (" + pos + ") that doesn't fit with " +
                        "this index's length (" + length + ")");
            }

            // Note: This method doesn't check if the given characterInputs contains two CharacterInput for the same
            // position
            Set<String> words = charactersIndexes.get(pos).getAll(input.getCharacter());

            if (result == null) {
                result = words;
            }
            else {
                // retainAll() retains each element in words and discards everything else.
                // So result <-- intersection of result and words
                result.retainAll(words);
            }

            // If intersection of inputs given so far is an empty set, then the final result will be empty.
            if (result.isEmpty()) {
                break;
            }
        }

        return result;
    }
}
