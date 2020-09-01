package com.exercises.manipulation.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReOrganize {

	public static void main(String[] args) {
	
		System.out.println("Input: aab => Expected aba => Result: " + solution("aab"));
	}
	
	public static String solution(String s) {
		Map<Character, Integer> counts = new HashMap<>();
		for(char c: s.toCharArray()) {
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}
		
		//Create a heap structure
		//Organize them to have most repeated char at the top.
		PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
		heap.addAll(counts.keySet());
		
		StringBuilder result = new StringBuilder();
		//There should be at least 2 records in the heap for this
		while(heap.size() > 1) {
			char current = heap.poll();
			char next = heap.poll();
			result.append(current).append(next);
			//Decrease number repetition
			counts.put(current, counts.get(current) - 1);
			counts.put(next, counts.get(next) - 1);
			//Add data again to the heap.
			if(counts.get(current) > 0) {
				heap.add(current);
			}
			if(counts.get(next) > 0) {
				heap.add(next);
			}
			
		}
		//If there is one record, count should not be more than 1
		if(!heap.isEmpty()) {
			char last = heap.poll();
			if(counts.get(last) > 1) {
				return "";
			}
			result.append(last);
		}
		
		return result.toString();
	}
}
