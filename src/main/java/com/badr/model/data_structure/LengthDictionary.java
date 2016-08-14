package com.badr.model.data_structure;

import com.badr.model.query.CharacterInput;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * A dictionary that indexes words by length and by characters per position. Facilitates searching for matches for
 * cross-word puzzle.
 * Created by mohannadhassan on 8/14/16.
 */
public class LengthDictionary {
    private HashMap<Integer, MultiCharIndex> index;

    public LengthDictionary(List<String> words) {
        if (words == null) {
            throw new IllegalArgumentException("words may not be null");
        }
        index = new HashMap<>();
        populateWords(words);
    }

    private void populateWords(List<String> words) {
        words.forEach(this::add);
    }

    private MultiCharIndex getMultiCharIndex(int length) {
        MultiCharIndex multiCharIndex = index.get(length);

        if (multiCharIndex == null) {
            multiCharIndex = new MultiCharIndex(length);
            index.put(length, multiCharIndex);
        }
        return multiCharIndex;
    }

    public void add(String word) {
        if (word == null) {
            throw new IllegalArgumentException("word may not be null");
        }
        if (word.length() == 0) {
            throw new IllegalArgumentException("word may not be an empty string");
        }

        MultiCharIndex lengthIndex = getMultiCharIndex(word.length());
        lengthIndex.add(word);
    }

    public Set<String> search(int wordLength, List<CharacterInput> characterInputs) {
        if (wordLength < 1) {
            throw new IllegalArgumentException("length may not be less than 1");
        }
        if (characterInputs == null) {
            throw new IllegalArgumentException("characterInputs may not be null");
        }

        return getMultiCharIndex(wordLength).search(characterInputs);
    }
}
