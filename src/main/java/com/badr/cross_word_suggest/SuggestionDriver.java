package com.badr.cross_word_suggest;

import com.badr.data_reader.DataReader;
import com.badr.model.data_structure.LengthDictionary;
import com.badr.model.query.MalformedQueryException;
import com.badr.model.query.QueryParser;
import com.badr.model.query.WordInput;

import java.io.*;
import java.util.List;
import java.util.Set;

/**
 * Created by mohannadhassan on 8/15/16.
 */
public class SuggestionDriver {

    private LengthDictionary dictionary;
    private Reader dataFileReadable;
    private BufferedReader userPromptReader;

    private QueryParser queryParser;

    private WordSearchResultPresenter presenter;

    public SuggestionDriver(Reader dataFileReadable, Reader userPromptReader) {
        this.dataFileReadable = dataFileReadable;
        this.userPromptReader = new BufferedReader(userPromptReader);

        queryParser = new QueryParser();
        presenter = new WordSearchResultPresenter();
    }

    public void start() {
        readDataFile();
        startMenu();
    }

    private void readDataFile() {
        DataReader dataReader = new DataReader(dataFileReadable);
        List<java.lang.String> words = dataReader.read();

        try {
            dataFileReadable.close();
        }
        catch (IOException e) {
            System.err.println("Exception while closing stream: " + dataFileReadable);
            e.printStackTrace();
        }
        dictionary = new LengthDictionary(words);
    }

    private void startMenu() {
        printUsage();

        while (true) {
            String s = readLine();

            String [] input = s.split("[ ]+");
            String command = input[0].toLowerCase();

            if (command.equals("q")) {
                quit();
                break;
            }

            if (input.length != 2) {
                System.out.println("Expected an input");
                printUsage();
            }
            else  {
                processInput(input[1]);
            }
        }
    }

    private String readLine() {
        String s = "";

        while (s.isEmpty()) {
            try {
                s = userPromptReader.readLine();
                if (s == null) {
                    quit();
                }
                else  {
                    s = s.trim();
                }
            } catch (IOException e) {
                //Suppress exception
                e.printStackTrace();
            }
        }

        return s;
    }

    private void printUsage() {
        System.out.println("s: Enter query.\n q: quit");
    }

    private void quit() {
        System.out.println("...");
        try {
            userPromptReader.close();
        } catch (IOException e) {
            System.err.println("Got an exception while closing stream: " +  userPromptReader);
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void processInput(String word) {
        WordInput wordInput;

        try {
            wordInput = queryParser.parse(word);
        }
        catch (MalformedQueryException e) {
            System.out.println("Input \"" + word + "\" is not a correct input");
            printUsage();
            return;
        }

        Set<String> words = dictionary.search(wordInput);
        presenter.presentResult(words);
    }
}
