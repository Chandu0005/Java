package com.chandu.java.collections.HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HashMapSortMainTest {

	public static void main(String[] args) {

		Vehicle v1 = new Vehicle("Car", 150);
		Vehicle v2 = new Vehicle("Telsa", 130);
		Vehicle v3 = new Vehicle("Bike", 150);
		Vehicle v4 = new Vehicle("Jeep", 180);

		// HashMap stores elements in key value pairs
		HashMap<Vehicle, String> vehicleOwnerMap = new HashMap<>();
		vehicleOwnerMap.put(v1, "Sachin");
		vehicleOwnerMap.put(v2, "Dhoni");
		vehicleOwnerMap.put(v3, "Dravid");
		vehicleOwnerMap.put(v4, "Ganguly");

		TreeMap<Vehicle, String> treeMap = new TreeMap<Vehicle, String>(vehicleOwnerMap);
		System.out.println("Sorted TreeMap by vehicle name: " + treeMap);

		// Sort by values
		Set<Entry<Vehicle, String>> entrySet = vehicleOwnerMap.entrySet();
		List<Entry<Vehicle, String>> vehicleEntryList = new ArrayList<>(entrySet);

		Collections.sort(vehicleEntryList, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));

		LinkedHashMap<Vehicle, String> lmp = new LinkedHashMap<Vehicle, String>();

		vehicleEntryList.forEach((entry) -> {
			lmp.put(entry.getKey(), entry.getValue());
		});
		System.out.println("Sorted Map by owner name: " + lmp);

	}

}
