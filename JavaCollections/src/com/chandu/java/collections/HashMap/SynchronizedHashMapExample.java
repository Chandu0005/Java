package com.chandu.java.collections.HashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//The disadvantage of using Collections.synchronizedMap() is that 
//it locks whole hashmap object and which may cause performance issue but ConcurrentHashMap only locks part of the map
//and performs quite well in a multithreaded environment.

public class SynchronizedHashMapExample {
	public static void main(String[] args) throws InterruptedException {

		// Using the sychronizedMap function of collections to make all operations of
		// HashMap Thread Safe
		Map<String, Integer> counterMap = Collections.synchronizedMap(new HashMap<>());

		counterMap.put("counter1", 0);
		counterMap.put("counter2", 100);

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);

		Runnable counterTask = () -> {
			incrementTime(counterMap, "counter1");
			incrementTime(counterMap, "counter2");

		};

		for (int i = 1; i <= 100; i++) {
			newFixedThreadPool.submit(counterTask);
		}

		newFixedThreadPool.shutdown();
		newFixedThreadPool.awaitTermination(30, TimeUnit.SECONDS);

		System.out.println("Time for Counter1: " + counterMap.get("counter1"));
		System.out.println("Time for Counter2: " + counterMap.get("counter2"));
	}

// Updating the incrementTime() method synchronized to solve above issue 
	public static synchronized void incrementTime(Map<String, Integer> counterMap, String counter) {
		Integer count = counterMap.get(counter);
		count++;
		counterMap.put(counter, count);
	}

//	output:
//  Time for Counter1: 100
//	Time for Counter2: 200

}
