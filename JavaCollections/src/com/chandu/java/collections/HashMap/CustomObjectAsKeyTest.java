package com.chandu.java.collections.HashMap;

import java.util.HashMap;

public class CustomObjectAsKeyTest {
	public static void main(String[] args) {
		Country india = new Country("India", 10000);
		Country japan = new Country("Japan", 3000);
		Country france = new Country("France", 5000);
		Country russia = new Country("Russia", 4000);

		// HashMap with Country name as key and capital as value
		// HashMap stores elements in key value pairs
		HashMap<Country, String> countryCapitalMap = new HashMap<>();
		countryCapitalMap.put(india, "Delhi");
		countryCapitalMap.put(japan, "Tokyo");
		countryCapitalMap.put(france, "Paris");
		countryCapitalMap.put(russia, "Moscow");

		System.out.println("-----------------------------");
		// Iterating HashMap Using keySet() and for each loop
		System.out.println("Iterating HashMap Using keySet() and for each loop");
		for (Country countryKey : countryCapitalMap.keySet()) {
			System.out.println(countryKey + " and  Capital:" + countryCapitalMap.get(countryKey));

		}
		System.out.println("-----------------------------");
	}

}
