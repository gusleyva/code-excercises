package com.exercises.array.manipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MostFrequentNumbers {

	public List<Integer> getMostFrequentNumbers(int[] nums, int k){
		Map<Integer, Integer> mostFrequentNumbers = new HashMap<>();
		
		for(int idx = 0; idx < nums.length; idx++) {
			mostFrequentNumbers.put(nums[idx], mostFrequentNumbers.getOrDefault(nums[idx], 0) + 1);
		}
		
		Map<Integer, Integer> sortedByValueDesc = 
			mostFrequentNumbers
			.entrySet()
			.stream()
			.sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
			.collect(Collectors.toMap(Map.Entry::getKey,
					Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		List<Integer> result = new ArrayList<>();
		int count = 0;
		for(Map.Entry<Integer, Integer> entry: sortedByValueDesc.entrySet()) {
			result.add(entry.getKey());
			count++;
			if(count >= k) {
				break;
			}
		}
		return result;
	}
	
	public List<Integer> getMostFrequetnNumbersPriorityQueue(int[] nums, int k){
		Map<Integer, Integer> mostFrequentNumbers = new HashMap<>();
		
		for(int idx = 0; idx < nums.length; idx++) {
			mostFrequentNumbers.put(nums[idx], mostFrequentNumbers.getOrDefault(nums[idx], 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> queue = 
				new PriorityQueue<>(
					(a, b) -> a.getValue().equals(b.getValue()) ?
							Integer.compare(b.getKey(), a.getKey()):
								Integer.compare(b.getValue(), a.getValue()));;
								
		for(Map.Entry<Integer, Integer> entry: mostFrequentNumbers.entrySet()) {
			queue.offer(entry);
		}
		
		List<Integer> result = new ArrayList<>();
		for(int idx = 0; idx < k && idx < queue.size(); idx++) {
			result.add(queue.poll().getKey());
		}
		
		return result;
	}
}
