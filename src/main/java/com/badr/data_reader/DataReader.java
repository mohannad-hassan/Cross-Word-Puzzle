package com.badr.data_reader;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by mohannadhassan on 8/15/16.
 */
public class DataReader {

    private Scanner scanner;

    private Pattern pattern;

    public DataReader(Readable dataSource) {
        openScanner(dataSource);
        pattern = Pattern.compile("[a-zA-Z]+");
    }

    private void openScanner(Readable dataSource) {
        scanner = new Scanner(dataSource);
        scanner.useDelimiter("\\s+");
    }

    public List<String> read() {
        LinkedList<String> list = new LinkedList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (pattern.matcher(word).matches()) {
                list.add(word);
            }
        }
        return list;
    }
}
