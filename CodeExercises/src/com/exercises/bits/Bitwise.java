package com.exercises.bits;

public class Bitwise {

	public static void main(String[] args) {
		System.out.println("Ouput: " + new Bitwise().solution(1011));
	}
	
	public int solution(int input) {
		System.out.println("Input: " + input);
		System.out.println("");
		int output = 0;
		
		while(input != 0) {
			//Shift left
			output = output <<= 1;
			System.out.println("Output: " + output);
			if((int)(input & 1) == 1) {
				output = output | 1;
				
				System.out.println("Add 1, Output: " + output);
			}
			//Shift to the right
			input = input >> 1;
			System.out.println("Input: " + input);
			System.out.println("");
		}
		System.out.println("Fina Output: " + output);
		
		return output;
	}
}
