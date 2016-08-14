package com.badr.model;

import com.badr.model.data_structure.MultiCharIndex;
import org.junit.Before;

import java.util.Arrays;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class MultiCharIndexTest {

    MultiCharIndex index;

    int length = 3;
    String [] words =
            {"abc", "aaa",
            "bcd", "bbb",
            "cde", "ccc",
            "def", "ddd",
            "efg", "eee"};

    @Before
    public void setUp() throws Exception {
        index = new MultiCharIndex(length, Arrays.asList(words));
    }


}