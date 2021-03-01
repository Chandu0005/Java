package com.chandu.java.collections.HashMap;

import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//HashMap is not thread-safe by default and it can give non-deterministic
//results in case of a multi-threaded environment.I have put two entries in map 
//with key as counter1 and counter2 and value as time 0 and 100 respectively.We have created a task which increment time for both counter by 1 
//and we are using ExecuterService to submit it 100 times.because we have submitted task 100 times and in each task execution, 
//it calls incrementTime()  and increases the time by 1.


public class HashMapNotThreadSafeTest {

	public static void main(String[] args) throws InterruptedException {

		Map<String, Integer> counterMap = new HashMap<>();

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

	public static void incrementTime(Map<String, Integer> counterMap, String counter) {
		Integer count = counterMap.get(counter);
		count++;
		counterMap.put(counter, count);
	}
	//Output is different from the last execution and this
	//is due to thread-safety issues in HashMap.


}