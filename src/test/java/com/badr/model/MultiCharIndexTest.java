package com.badr.model;

import com.badr.model.data_structure.MultiCharIndex;
import com.badr.model.query.CharacterInput;
import org.junit.Before;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class MultiCharIndexTest extends junit.framework.TestCase {

    private MultiCharIndex index;

    private int length = 3;
    private String [] words =
            {"abc", "aaa",
            "bcd", "bbb",
            "cde", "ccc",
            "def", "ddd",
            "efg", "eee",
            "zxy", "zxx"};

    @Before
    public void setUp() throws Exception {
        index = new MultiCharIndex(length, Arrays.asList(words));
    }

    @org.junit.Test
    public void testSingleCharacter() {
        Set<String> result = index.search(Arrays.asList(new CharacterInput(0, 'a')));

        assertEquals(result.size(), 2);
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("aaa"));

        result = index.search(Arrays.asList(new CharacterInput(1, 'a')));
        assertEquals(result.size(), 1);
        assertTrue(result.contains("aaa"));
    }

    @org.junit.Test
    public void testMultiCharacters() {
        Set<String> result = index.search(Arrays.asList(new CharacterInput(0, 'z'), new CharacterInput(1, 'x')));

        assertEquals(result.size(), 2);
        assertTrue(result.contains("zxy"));
        assertTrue(result.contains("zxx"));
    }

    @org.junit.Test
    public void testAllCharacters() {
        Set<String> result = index.search(Arrays.asList(new CharacterInput(0, 'z'), new CharacterInput(1, 'x'),
                new CharacterInput(2, 'y')));

        assertEquals(result.size(), 1);
        assertTrue(result.contains("zxy"));
    }

    @org.junit.Test
    public void testConsecutiveAdd() {
        MultiCharIndex index = new MultiCharIndex(3);

        index.add("abc");
        index.add("aar");
        index.add("xyz");

        Set<String> result = index.search(Arrays.asList(new CharacterInput(0, 'a')));

        assertEquals(result.size(), 2);
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("aar"));
    }
}