package com.exercises.array.rearrange;

import java.util.Arrays;

public class SortedSquares {
	
	public static void main(String[] args) {
		//-4,-1,0,3,10
		System.out.println(Arrays.toString(sortedSquaresV2(new int[] {-4,-1,0,3,10})));
		System.out.println(Arrays.toString(sortedSquaresV2(new int[] {-6,-4,1,2,3,5})));
	}
	
	public static int[] sortedSquaresV2(int[] input) {
		System.out.println(Arrays.toString(input));
		int[] output = new int[input.length];
		int left = 0;
		int right = input.length - 1;
		
		for(int i = input.length -1; i >= 0; i--) {
			if(Math.abs(input[left]) > input[right]) {
				output[i] = input[left] * input[left];
				left++;
			}else {
				output[i] = input[right] * input[right];
				right--;
			}
		}
		
		return output;
	}
	
	public static int[] sortedSquares(int[] input) {
		System.out.println(Arrays.toString(input));
		int length = input.length - 1;
		int[] output = new int[input.length];
		int head = 0;
		int tail = length;
		int index = length;
		while(index >= 0) {
			int numHead = input[head]; //-4 -> -1
			int numTail = input[tail]; //10 -> 3 -> 0
			//-4,-1,0,3,10
			//   h,,t  
			if(numHead < 0) {
				if(Math.abs(numHead) > numTail) { //4 > 3 -> 1 > 3 -> 1 > 0
					output[index] = numHead * numHead;
					head++; //0 -> 1 -> 2
				}else {
					output[index] = numTail * numTail;
					tail--; //4 -> 3 -> 2
				}
				//0,1,9,16,100
			}else {
				output[index] = numTail * numTail;
				tail--;
			}
			index--;
		}
		
		
		return output;
	}
	
}
