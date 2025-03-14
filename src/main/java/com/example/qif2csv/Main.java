package com.example.qif2csv;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Verwendung: java -jar qif-to-csv.jar <input.qif> <output.csv>");
            System.exit(1);
        }

        String qifFilePath = args[0];
        String csvFilePath = args[1];

        try {
            Qif2CsvConverter.convert(qifFilePath, csvFilePath);
            System.out.println("Konvertierung erfolgreich! CSV-Datei: " + csvFilePath);
        } catch (IOException e) {
            System.err.println("Fehler bei der Konvertierung: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
