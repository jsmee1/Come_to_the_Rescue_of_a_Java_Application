package com.hemebiotech.analytics;

import java.util.*;
import java.util.stream.Collectors;

public class SymptomUtils {
    public static Map<String, Integer> countSymptoms(List<String> symptomList) {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        for (String symptom : symptomList) {
            Integer value = myMap.get(symptom);
            if (value == null)
                myMap.put(symptom, 1);
            else
                myMap.put(symptom, value+1);
        }
        return myMap;
    }
        // Sort symptoms by name
    public static TreeMap<String, Integer> sortSymptoms(Map<String, Integer> symptomMap) {
 /*       Map<String, Integer> mySortedMap = symptomMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new)); */
        // Copy the Map into a TreeMap to sort it
        TreeMap<String, Integer> mySortedMap = new TreeMap<String, Integer>();
//        mySortedMap = (TreeMap<String, Integer>) symptomMap;
        mySortedMap.putAll(symptomMap);
        return mySortedMap;
    }

}
