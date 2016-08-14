package com.badr.model.query;

import java.util.ArrayList;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class QueryParser {

    public WordInput parse(String input) throws MalformedQueryException {
        if (input == null) {
            throw new IllegalArgumentException("input may not be null");
        }

        ArrayList<CharacterInput> characterInputs = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '-') {
                if (Character.isLetter(c)) {
                    characterInputs.add(new CharacterInput(i, c));
                }
                else {
                    throw new MalformedQueryException(c, input);
                }
            }
        }
        return new WordInput(input.length(), characterInputs);
    }
}
