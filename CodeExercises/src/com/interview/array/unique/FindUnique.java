package com.interview.array.unique;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindUnique {

	public static void main(String[] args) {
		System.out.println("Input: [4,1,2,1,2], result: " + singleNumberHashMap(new int[] {4,1,2,1,2}) );
	}
	
	
	/**
	 * Time complexity : O(n * 1) = O(n) O(n⋅1) =O(n). 
	 * Time complexity of for loop is O(n) O(n). 
	 * Time complexity of hash table(dictionary in python) operation pop is O(1)O(1).

	   Space complexity : O(n)O(n). The space required by hash\_tablehash_table is equal 
	   to the number of elements in \text{nums}nums.

	 * @param nums
	 * @return
	 */
	public static int singleNumberHashMap(int[] nums) {
		Map<Integer, Integer> hm = new HashMap<>();
		
		for(int i: nums) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
		
		for(Map.Entry<Integer, Integer> mapEntry: hm.entrySet()) {
			if(mapEntry.getValue() == 1) {
				return mapEntry.getKey();
			}
		}
		
		return 0;
	}
	
	/**
	 * Linear runtime complexity, without using extra memory?
	 * 
	 * Use a set
	 * Sort them and iterate them - 2n
	 * Brute force solution
	 * @param nums
	 * @return
	 */
	public static int singleNumberSort(int[] nums) {
		//TODO
		System.out.println("Before sorting: " + Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println("After sorting: " + Arrays.toString(nums));
		int counter = 1;
		int uniqueNumber = nums[0];
		for(int i = 1; i < nums.length; ++i) {
			int tmpNum = nums[i]; //
			if(uniqueNumber == tmpNum) { 
				counter++;
			}else {
				if(counter == 1) {
					System.out.printf("Unique Number: [%d], counter: [%d] \n", uniqueNumber, counter);
					return uniqueNumber;
				}else {
					System.out.printf("Multiple Number: [%d], counter: [%d] \n", uniqueNumber, counter);
					counter = 1; //restart counter
					uniqueNumber = tmpNum;
				}
				
			}
		}
		
		return uniqueNumber;
	}
}
