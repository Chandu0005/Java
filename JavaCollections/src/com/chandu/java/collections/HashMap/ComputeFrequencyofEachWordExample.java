package com.chandu.java.collections.HashMap;

import java.util.HashMap;

public class ComputeFrequencyofEachWordExample {

	public static void main(String[] args) {

		String str = "javalavacova";

		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);

//			map.computeIfPresent(c, (character, count) -> count + 1);
//			map.computeIfAbsent(c, (Character) -> 1);
			if (map.containsKey(c)) {
				int count = map.get(c);
				map.put(c, count + 1);
			} else {
				map.put(c, 1);

			}
		}
		System.out.println(map);
	}

}
