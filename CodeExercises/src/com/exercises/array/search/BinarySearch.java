package com.exercises.array.search;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println("Result: " + binarySearchTavo(new int[] {2,4,6,8,10}, 2));
		System.out.println("Result: " + binarySearchTavo(new int[] {2,4,5,6,7,8,9,10}, 8));
		System.out.println("Result: " + binarySearchTavo(new int[] {2,4,6,8,10}, 10));
		System.out.println("Result: " + binarySearchTavo(new int[] {2,4,6,8,10}, 8));
		System.out.println("Result: " + binarySearchTavo(new int[] {2,4,6,8,10}, 11));
		System.out.println("Result: " + binarySearchTavo(new int[] {4,7,11,19,123,150,300}, 2));
		System.out.println("Result: " + binarySearchTavo(new int[] {4,7,11,19,123,150,300}, 300));
		System.out.println("Result: " + binarySearchTavo(new int[] {6,14,19,25}, 6));
		System.out.println("Result: " + binarySearchTavo(new int[] {6,14,19,25}, 14));
		System.out.println("Result: " + binarySearchTavo(new int[] {6,14,19,25}, 19));
		System.out.println("Result: " + binarySearchTavo(new int[] {6,14,19,25}, 25));
		System.out.println("Result: " + binarySearchTavo(new int[] {6,14,19,25}, 2));
		System.out.println("Result: " + binarySearchTavo(new int[] {6,14,19,25}, 24));
		
	}
	
	public static boolean binarySearchTavo(int[] input, int num) {
		if(input == null || input.length == 0) {
			return false;
		}
		System.out.println("input: " + Arrays.toString(input) + ", search: " + num);
		int size = input.length - 1;
		int low = 0;
		int high = size;
		
		for(int i = 0; i <= (size / 2); i++) {
			int middle = (low + high) / 2;
			int tmpVal = input[middle];
			System.out.printf("middle: [%d], tmpVal: [%s] \n", middle, tmpVal);
			if(num == tmpVal) {
				System.out.println("position: " + middle);
				return true;
			}else if(num > tmpVal) { //right
				low = middle + 1;
			}else {//left;
				high = middle - 1;
			}
		}
		
		return false;
	}
}
