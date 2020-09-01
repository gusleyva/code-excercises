package com.exercises.array.sum;

import java.util.Arrays;

public class Sum {

	public static void main(String[] args) {
		int[] input = new int[] {1,2,3,4,5}; //15
		Sum sum = new Sum();
		System.out.println("Sum: " + sum.solution(input));
	}
	
	public int solution(int[] a) {
		System.out.println("Input: " + Arrays.toString(a));
		if(a.length == 0)
			return 0;
		
		if(a.length == 1)
			return a[0];
		
		return solution(a, 0, 0);
	}
	
	public int solution(int[] a, int sum, int index) {
		if(index < a.length) {
			System.out.printf("sum: [%d], index: [%d], value array: [%d] \n", sum, index, a[index]);
			return solution(a, sum+= a[index], ++index);
		}
		return sum;
	}
	
	
}
