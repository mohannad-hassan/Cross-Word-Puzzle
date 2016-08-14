package com.badr.model;

import static org.junit.Assert.*;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class AlphabetIndexTest extends junit.framework.TestCase {

    AlphabetIndex index;
    String [] words
            = {"abc", "bcd", "cde", "def", "efg",
               "aaa", "bbb", "ccc", "ddd", "eee"};

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        index = new AlphabetIndex();
    }

    
}