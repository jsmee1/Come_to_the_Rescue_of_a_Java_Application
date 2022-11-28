package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		Map<String, Integer> myMap = new HashMap<String, Integer>();
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		while (line != null) {
			System.out.println("symptom from file: " + line);
			Integer value = myMap.get(line);
			if (value == null)
				myMap.put(line, 1);
			else
				myMap.put(line, value+1);

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
/*		myMap.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}); */
		System.out.println("\n");
		System.out.println("\n");
		Map<String, Integer> mySortedMap = myMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
/*		System.out.println(mySortedMap); */
		mySortedMap.entrySet().forEach(entry -> {
			try {
			writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
			} catch(IOException e) {e.printStackTrace();}
		});
// instead of writing from the stream, you can construct the entire String in memory and then write it all at once.
//		String data = mySortedMap.entrySet().forEach(entry.getKey() + " : " + entry.getValue() + "\n")
/*		Arrays.asList(10, 23, -4, 0, 18).stream().sorted().forEach(System.out::println); */
/*		myMap.entrySet().stream().sorted().forEach(entry -> {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		});*/
		writer.close();
	}
}
