package com.badr.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
