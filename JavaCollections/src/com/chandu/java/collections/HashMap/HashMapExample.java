package com.chandu.java.collections.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {

		HashMap<Integer, String> employeehm = new HashMap<>();

		// check if map is empty
		boolean empty = employeehm.isEmpty();
		System.out.println("Is Employee Hash Map  empty: " + empty);

		// Add key-value pairs to HashMap . We can use put() method to add entries to
		// HashMap.
		employeehm.put(1, "Sachin");
		employeehm.put(2, "Shewag");
		employeehm.put(3, "Dravid");
		employeehm.put(4, "Laxman");
		employeehm.put(5, "Yuvaraj");

		// check size of map
		System.out.println("size of Employee Hash Map is: " + employeehm.size());

		// get value from Employee HashMap
		System.out.println("Employee Key-1 value is: " + employeehm.get(1));
		// Robin's department will be null as we don't have key as 6
		System.out.println("Employee Key-6 value is:: " + employeehm.get(6));

		// What if you want to add entries only if it is not already present in HashMap?
		// You can use putIfAbsent() the method in this scenario.

		// remove(Object key,Object value): It removes key if value is same as passed
		// parameter value.
		// removes the key 5 as the value is same as the list
		boolean rm2 = employeehm.remove(5, "Yuvaraj");

		// remove(Object key): It removes key from HashMap
		// Removes the key 3 from the map.
		String rm1 = employeehm.remove(4);
		System.out.println(employeehm);

		if (employeehm.containsKey(1)) {
			System.out.println("Employee HashMap has 1 as the key");
		}

		if (employeehm.containsValue("Sachin")) {
			System.out.println("Employee HashMap has Sachin as the value");
		}
		// get entrySet
		Set<Entry<Integer, String>> entrySet = employeehm.entrySet();
		System.out.println("EntrySet:" + entrySet);
		// get keySet
		Set<Integer> keySet = employeehm.keySet();
		System.out.println("keySet: " + keySet);
		// get values
		Collection<String> values = employeehm.values();
		System.out.println("values: " + values);

		// Removing all entries from Map
		// employeehm.clear();
		System.out.println(employeehm);

		System.out.println("=========================================================");
		System.out.println("Iterating over HashMap with foreach and lambda:");
		employeehm.forEach((userid, Name) -> {
			System.out.println(userid + " --> " + Name);
		});

		System.out.println("=========================================================");
		System.out.println("Iterating over HashMap using keyset() with foreach loop:");
		for (Integer userid : employeehm.keySet()) {
			System.out.println(userid + " --> " + employeehm.get(userid));
		}
		System.out.println("=========================================================");
		System.out.println("Iterating over HashMap's keyset() with foreach and lambda:");
		employeehm.keySet().forEach((userid) -> {
			System.out.println(userid + " --> " + employeehm.get(userid));
		});

		System.out.println("=========================================================");
		System.out.println("Iterating over HashMap's entrySet with iterator");
		Iterator<Entry<Integer, String>> iterator = employeehm.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, String> next = iterator.next();
			System.out.println(next.getKey() + " --> " + next.getValue());
		}

		System.out.println("=========================================================");
		System.out.println("Iterating over HashMap's entrySet with foreach and lambda");
		employeehm.entrySet().forEach((entry) -> {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		});

		System.out.println("=========================================================");
		System.out.println("Iterating over HashMap's entrySet with foreach loop");
		for (Entry<Integer, String> entry : employeehm.entrySet()) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}

		// Java 8‘s Map interface introduced new methods such as compute(),
		// computeIfPresent()
		// and computeIfAbsent() which help you write code using lambda expressions.

		HashMap<String, Integer> teammap = new HashMap<>();
		teammap.put("team1", 1);
		teammap.put("team2", 1);
		// Now you want to add 1 goal to team1 and generally, you do it as follow.

		teammap.put("team1", teammap.get("team1") + 1);

		// Instead, you can easily do it with compute as below.So whenever you want to
		// apply mappings
		// based on key, value pair then compute should be used.
		teammap.compute("team1", (team, goal) -> goal + 1);

		// computeIfPresent recomputes the value if specified key is present and value
		// is not null.
		// You might have written code like below before:

		if (teammap.containsKey("team1")) {
			teammap.put("team1", teammap.get("team1") + 1);
		}

		// You can rewrite this with computeIfPresent as below,If function returns null,
		// then key will be removed from HashMap.

		teammap.computeIfPresent("team1", (team, goal) -> goal + 1);

		// computeIfAbsent recomputes the value if specified key is not present and
		// function does not return null.
		teammap.computeIfAbsent("team3", value -> 0);

		System.out.println(teammap);

	}

}
