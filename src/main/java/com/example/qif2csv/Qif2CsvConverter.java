package com.example.qif2csv;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Qif2CsvConverter {

    public static void convert(String qifFilePath, String csvFilePath) throws IOException {
        Set<String> keys = QifParser.parseKeys(qifFilePath);

        List<QIFMap> entries = QifParser.parse(qifFilePath, keys);
        System.err.println("wrote: " + (entries.size()-1) + " lines.");
        
        CsvWriter.write(csvFilePath, entries);
    }
}
