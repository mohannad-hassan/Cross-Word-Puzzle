package com.badr.data_reader;

import junit.framework.TestCase;

import java.io.*;
import java.util.List;

/**
 * Created by mohannadhassan on 8/15/16.
 */
public class DataReaderTest extends TestCase {

    private BufferedReader br;
    private DataReader dataReader;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String filePath =  classLoader.getResource("com.badr.data_reader/small_data_file").getFile();
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        }
        catch ( IOException e) {
            System.err.println("Caught exception while opening file: " + e);
        }
        dataReader = new DataReader(br);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        br.close();
    }

    @org.junit.Test
    public void testSmallDataFile() {
        List<String> words = dataReader.read();
        words.forEach(System.out::println);
        assertEquals(words.size(), 9);
    }
}