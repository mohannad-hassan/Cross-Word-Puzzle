package com.badr.model.data_structure;

import com.badr.model.query.CharacterInput;
import junit.framework.TestCase;
import org.junit.Before;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class LengthDictionaryTest extends TestCase {

    private LengthDictionary dictionary;

    private String [] words = {"abc", "ado", "akka", "bi", "bbc", "ball", "bake", "Electrical"};

    @Before
    public void setUp() throws Exception {
        dictionary = new LengthDictionary(Arrays.asList(words));
    }

    @org.junit.Test
    public void testSearch() {
        Set<String> result = dictionary.search("akka".length(), Arrays.asList(new CharacterInput(2, 'k')));

        assertEquals(result.size(), 2);
        assertTrue(result.contains("akka"));
        assertTrue(result.contains("bake"));

        result = dictionary.search("akka".length(), Arrays.asList(new CharacterInput(2, 'k'),
                new CharacterInput(0, 'a')));

        assertEquals(result.size(), 1);
        assertTrue(result.contains("akka"));
    }

    @org.junit.Test
    public void testAdd() {
        dictionary.add("dortmund");
        dictionary.add("lake");

        Set<String> result = dictionary.search("akka".length(), Arrays.asList(new CharacterInput(2, 'k')));

        assertEquals(result.size(), 3);
        assertTrue(result.contains("akka"));
        assertTrue(result.contains("bake"));
        assertTrue(result.contains("lake"));

        result = dictionary.search("dortmund".length(), Arrays.asList(new CharacterInput(0, 'd')));

        assertEquals(result.size(), 1);
    }
}