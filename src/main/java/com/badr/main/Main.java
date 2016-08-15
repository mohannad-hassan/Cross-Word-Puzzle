package com.badr.main;

import com.badr.cross_word_suggest.SuggestionDriver;

import java.io.*;

/**
 * Created by mohannadhassan on 8/14/16.
 */
public class Main {

    public static void main(String ... args) {
        if (args.length < 1) {
            System.err.println("The path for the data file is expected as the first argument");
            System.exit(-1);
        }

        String inputFilePath = args[0];

        BufferedReader dataInputReader = null;

        try {
            dataInputReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath)));
        }
        catch (FileNotFoundException e) {
            System.err.println("Input file does not exist: " + inputFilePath);
            System.exit(-1);
        }

        BufferedReader userPromptStream = new BufferedReader(new InputStreamReader(System.in));


        SuggestionDriver suggestionDriver = new SuggestionDriver(dataInputReader, userPromptStream);
        suggestionDriver.start();
    }
}
