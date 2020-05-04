package com.exercises.array.duplicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {

	public static void main(String[] args) {
		System.out.println("Duplicates: " + solution(new int[] {1,2,3}));
		System.out.println("Duplicates: " + solution(new int[] {1,2,2}));
		System.out.println("Duplicates: " + solution(new int[] {3,3,3}));
		System.out.println("Duplicates: " + solution(new int[] {2,1,2,1}));
	}
	
	public static String solution(int[] input) {
		System.out.println("Input: " + Arrays.toString(input));
		Map<Integer, Integer> nums = new HashMap<>();
		List<Integer> duplicates = new ArrayList<>();
		
		for(int n: input) {
			if(nums.containsKey(n)) {
				int ocurrences = nums.get(n);
				if(ocurrences == 1)
					duplicates.add(n);
				nums.put(n, ocurrences + 1);
			}else {
				nums.put(n, 1);
			}
		}
		
		return duplicates.toString();
	}
}
