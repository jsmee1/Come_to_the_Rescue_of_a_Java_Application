package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MyAnalyticsCounter {

	public static void main(String args[]) throws Exception {

		List<String> symptomList;
		Map<String, Integer> symptomMap;
	//	Read symptoms into a list
		SymptomReader reader = new SymptomReader("symptoms.txt");
		symptomList = reader.GetSymptoms();
	/*	for (String symptom : symptomList) {
			System.out.println(symptom);
		} */
		if (symptomList.isEmpty())
			System.out.println("No symptoms found");
		else {
			symptomMap = SymptomUtils.countSymptoms(symptomList);
			symptomMap = SymptomUtils.sortSymptoms(symptomMap);
			SymptomWriter writer = new SymptomWriter("result.out");
			writer.putSymptoms(symptomMap);
		}

	}
}
