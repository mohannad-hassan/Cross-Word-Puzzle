package com.badr.main;

import com.badr.model.data_structure.LengthDictionary;
import com.badr.model.query.MalformedQueryException;
import com.badr.model.query.QueryParser;
import com.badr.model.query.WordInput;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

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

        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(inputFilePath)));
            scanner.useDelimiter("\\s+");
        }
        catch (FileNotFoundException e) {
            System.err.println("Input file does not exist: " + inputFilePath);
        }

        long time = System.currentTimeMillis();
        LengthDictionary dictionary = new LengthDictionary();

        int count = 0;

        while (scanner.hasNext()) {
            dictionary.add(scanner.next());
            count++;
            if (count % 10000 == 0) {
                System.out.println("Processed " + count + " words");
            }
        }
        scanner.close();

        System.out.println("s: Enter query.\n q: quit");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        QueryParser parser = new QueryParser();

        while (true) {
            String s = null;
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String [] input = s.split("[ ]+");
            String command = input[0].toLowerCase();
            if (command.equals("q")) {
                System.out.println("...");
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            else if(command.equals("s")) {
                if (input.length != 2) {
                    //Error
                }
                else  {
                    String word = input[1];

                    WordInput wordInput = null;

                    try {
                        wordInput = parser.parse(word);
                    }
                    catch (MalformedQueryException e) {
                        // Wrong Input
                    }

                    Set<String> words = dictionary.search(wordInput);

                    System.out.println("Got " + words.size() + " words");
                    int length = words.size() > 100 ? 100 : words.size();

                    Iterator<String> iterator = words.iterator();
                    while (iterator.hasNext() && length -- > 0) {
                        System.out.println(iterator.next());
                    }
                }
            }
        }


        long time2 = System.currentTimeMillis();

        System.out.println(count + " words at " + (time2 - time) / 1000.0 + " seconds.");
    }
}
