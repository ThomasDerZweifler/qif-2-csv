package com.example.qif2csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public static void write(String filePath, List<QIFMap> entries) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // CSV-Header
            
            entries.get(0).map.keySet().forEach(key -> {
                try {
                    writer.write(key + ",");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.newLine();

            // Daten schreiben
            for (QIFMap entry : entries) {
                
                entry.map.values().forEach(value -> {
                    try {
                        writer.write(escapeCsvField(value) + ",");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.newLine();
            }
        }
    }

    private static String escapeCsvField(String field) {
        if (field == null) {
            return "";
        }
        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }
}
