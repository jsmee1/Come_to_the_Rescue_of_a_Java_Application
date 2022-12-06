package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * New version of AnalyticsCounter
 * Count symptoms and sort them alphabetically
 */
public class MyAnalyticsCounter {
	/**
	 *
	 * @param  args - default unused parameter
	 */
	public static void main(String[] args) {

		List<String> symptomList;
		Map<String, Integer> symptomMap;
	//	Read symptoms into a list
		SymptomReader reader = new SymptomReader("symptoms.txt");
		symptomList = reader.GetSymptoms();
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
