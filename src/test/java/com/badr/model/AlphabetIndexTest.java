package com.badr.model;


import com.badr.model.data_structure.AlphabetIndex;

import java.util.Set;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class AlphabetIndexTest extends junit.framework.TestCase {

    private AlphabetIndex index;
    private String [] words
            = {"abc", "bcd", "cde", "def", "efg",
               "aaa", "bbb", "ccc", "ddd", "eee"};

    Character [] characters = {'a', 'b', 'c', 'e'};
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        index = new AlphabetIndex();
    }

    @org.junit.Test
    public void testGetAll() throws Exception {
        for (String word :
                words) {
            index.put(word.charAt(0), word);
        }
        Set<String> words = index.getAll('a');

        assertEquals(words.size(), 2);
        assertTrue(words.contains("abc"));
        assertTrue(words.contains("aaa"));

        for (Character c :
                characters) {
            assertEquals(index.getAll(c).size(), 2);
        }
    }
}