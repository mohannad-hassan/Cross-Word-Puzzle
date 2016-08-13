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

    public MultiCharIndex(int length) {
        if (length < 1 || length > LONGEST_POSSIBLE_LENGTH) {
            throw new IllegalArgumentException("Illegal value for length: " + length + ". length should be between " +
                    "1 and " + LONGEST_POSSIBLE_LENGTH);
        }
        this.length = length;
        this.charactersIndexes = new ArrayList<AlphabetIndex>(length);
    }

    private class AlphabetIndex {

    }
}
