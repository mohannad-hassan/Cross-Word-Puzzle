package com.badr.model.data_structure;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * Indexes words by a character. The index doesn't assume any specific range for characters.
 * Created by mohannadhassan on 8/14/16.
 */
public class AlphabetIndex {

    private HashMap<Character, Set<String>> characterToWordsIndex;

    public AlphabetIndex() {
        characterToWordsIndex = new HashMap<Character, Set<String>>();
    }

    /**
     * Adds <code>word</code> to the set indexed by <code>c</code>.
     * @param c Index character
     * @param word Input word
     */
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

    /**
     * Returns the set of words indexed by <code>c</code>.
     * @param c Index character
     * @return The set of indexed words, or an empty set if no word has been indexed by <code>c</code>
     */
    private Set<String> getWords(Character c) {
        Set<String> words = characterToWordsIndex.get(c);

        if (words == null) {
            words = new TreeSet<String>();
            characterToWordsIndex.put(c, words);
        }

        return words;
    }

    /**
     * Returns the set of words indexed by <code>c</code>.
     * @param c Index character
     * @return The set of indexed words, or an empty set if no word has been indexed by <code>c</code>
     */
    public Set<String> getAll(Character c) {
        if (!characterToWordsIndex.containsKey(c)) {
            return new TreeSet<String>();
        }
        return getWords(c);
    }
}
