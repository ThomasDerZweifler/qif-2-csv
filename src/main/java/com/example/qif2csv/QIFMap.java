package com.example.qif2csv;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class QIFMap {
    Map<String, String> map = new HashMap<String, String>();
    public QIFMap(Set<String> keys) {
        for (String string : keys) {
            map.put(string, "");
        }
    }
    @Override
    public String toString() {
        return "QIFMap [map=" + map + "]";
    }
}
