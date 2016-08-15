package com.badr.cross_word_suggest;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by mohannadhassan on 8/15/16.
 */
public class WordSearchResultPresenter {

    protected void presentResult(Set<String> words) {
        System.out.println("Got " + words.size() + " word" + (words.size() > 1 ? "s" : ""));
        int length = words.size() > 100 ? 100 : words.size();

        if (length != words.size()) {
            System.out.println("Printing first " + length + " words");
        }

        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext() && length -- > 0) {
            System.out.println("\t" + iterator.next());
        }
    }
}
