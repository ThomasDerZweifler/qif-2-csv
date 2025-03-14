package com.example.qif2csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QifParser {

    static Set<String> set = new HashSet<String>();

    public static Set<String> parseKeys(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                set.add(line.substring(0, 1));
            }
        }
        set.remove("!");
        set.remove("^");
        return set;
    }

    public static List<QIFMap> parse(String filePath, Set<String> keys) throws IOException {
        List<QIFMap> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Map<String, String> map = new HashMap<String, String>();

            while ((line = reader.readLine()) != null) {

                String key = line.substring(0, 1);

                if (key.equals("!")) {
                    continue;
                }
                else if (key.equals("^")) {
                    QIFMap entry = new QIFMap(keys);
                    entry.map.putAll(map);
                    entries.add(entry);
                    map.clear();
                    continue;
                }

                String value = line.substring(1);
                map.put(key,value);
                
            }
        }
        return entries;
    }
}

