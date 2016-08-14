package com.badr.model.data_structure;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class LengthDictionary {
    private HashMap<Integer, MultiCharIndex> index;

    public LengthDictionary(List<String> words) {
        if (words == null) {
            throw new IllegalArgumentException("words may not be null");
        }
        index = new HashMap<Integer, MultiCharIndex>();
        populateWords(words);
    }

    private void populateWords(List<String> words) {
        for (String word :
                words) {
            int length = word.length();
            if (length == 0) {
                throw new IllegalArgumentException("input words contain an empty string");
            }

            MultiCharIndex lengthIndex = getMultiCharIndex(word.length());
            lengthIndex.add(word);
        }
    }

    private MultiCharIndex getMultiCharIndex(int length) {
        MultiCharIndex multiCharIndex = index.get(length);

        if (multiCharIndex == null) {
            multiCharIndex = new MultiCharIndex(length);
            index.put(length, multiCharIndex);
        }
        return multiCharIndex;
    }
}