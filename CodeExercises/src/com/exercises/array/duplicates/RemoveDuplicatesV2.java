package com.exercises.array.duplicates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesV2 {

	public static void main(String[] args) {
		RemoveDuplicatesV2 rd = new RemoveDuplicatesV2();
		System.out.println(Arrays.toString(rd.removeDuplicatesV1(new int[] {1,2,3,3,3,4,4,5})));
		
	}
	private int[] removeDuplicatesV1(int[] nums) {
		Set<Integer> unique = new HashSet<>();
		for(int n: nums) {
			unique.add(n);
		}
		//return unique.toArray(new Integer[unique.size()]);
		return unique.stream().mapToInt(Integer::intValue).toArray();
	}
}
