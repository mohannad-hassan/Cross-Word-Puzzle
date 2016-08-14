package com.badr.model;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class AlphabetIndex {

    private HashMap<Character, Set<String>> characterToWordsIndex;

    public AlphabetIndex() {
        characterToWordsIndex = new HashMap<Character, Set<String>>();
    }

    public void put(Character c, String word) {
        if (c == null) {
            throw new IllegalArgumentException("Input character 'c' may not be null");
        }
        if (word == null) {
            throw new IllegalArgumentException("Input word may not be null");
        }

        Set<String> words = getWords(c);
        words.add(word);
    }

    private Set<String> getWords(Character c) {
        Set<String> words = characterToWordsIndex.get(c);

        if (words == null) {
            words = new TreeSet<String>();
            characterToWordsIndex.put(c, words);
        }

        return words;
    }
}
