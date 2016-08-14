package com.badr.data_reader;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mohannadhassan on 8/15/16.
 */
public class DataReader {

    private Scanner scanner;

    public DataReader(Readable dataSource) {
        openScanner(dataSource);
    }

    private void openScanner(Readable dataSource) {
        scanner = new Scanner(dataSource);
        scanner.useDelimiter("\\s+");
    }

    public List<String> read() {
        LinkedList<String> list = new LinkedList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            list.add(word);
        }
        return list;
    }
}
