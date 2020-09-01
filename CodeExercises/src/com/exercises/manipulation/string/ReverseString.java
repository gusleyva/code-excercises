package com.exercises.manipulation.string;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println("Input: hola, output: " + rs.reverseV1("hola"));
		System.out.println("Input: hola, output: " + rs.reverseV2("hola"));
	}
	
	private String reverseV1(String input) {
		StringBuilder sb = new StringBuilder();
		for(int i = input.length() - 1; i >= 0; i--) {
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}
	
	private String reverseV2(String input) {
		char[] arrInput = input.toCharArray();
		for(int i = 0; i < input.length() / 2; i++) {
			char tmp = arrInput[i];
			arrInput[i] = arrInput[arrInput.length - 1 - i];
			arrInput[arrInput.length - 1 - i] = tmp;
		}
		return Arrays.toString(arrInput);
	}
}
