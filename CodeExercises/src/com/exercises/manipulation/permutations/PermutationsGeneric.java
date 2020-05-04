package com.exercises.manipulation.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsGeneric {

	public static void main(String[] args) {
		PermutationsGeneric p = new PermutationsGeneric();
		List<int[]> results = p.permutations(new int[] {1,2,3});
		p.print(results);
	
	}
	public List<int[]> permutations(int[] a){
		System.out.println("input: " + Arrays.toString(a));
		List<int[]> results = new ArrayList<>();
		permutations(a, 0, results);
		return results;
	}
	
	public void permutations(int[] a, int start, List<int[]> results) {
		if(start >= a.length) {
			results.add(a.clone()); //Create a new array, don't add an array reference
		}else {
			for(int i = start; i < a.length; i++) {
				swap(a, start, i); 
				permutations(a, start + 1, results);
				swap(a, start, i);
			}
		}
	}
	
	public void swap(int[] a, int start, int i) {
		int tmp = a[start];
		a[start] = a[i];
		a[i] = tmp;
	}
	
	public void print(List<int[]> results) {
		for(int[] result: results) {
			System.out.println(Arrays.toString(result));
		}
		System.out.println();
	}
}
