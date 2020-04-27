package com.exercises.manipulation.string.compressed;

public class StringCompressed {

	public static void main(String[] args) {
		System.out.println("Input: ABBBCCDDCCC, minCompressedInput: " + solution("ABBBCCDDCCC", 3));
	}
	
	public static int solution(String input, int k) {
		//TODO
		int minCompressedInput = input.length();
		char[] arrInput = input.toCharArray();
		
		System.out.println("Input: " + input);
		for(int i = 0; i < arrInput.length - 3; i++) { //
			//Ignore from i to i + 2
			int counter = 0;
			char c = arrInput[0]; //Start at the beggining input
			StringBuilder sb = new StringBuilder();
			int tmpPosition = -1;
			for(int j = 0; j < arrInput.length; j++) {
				if(j >= i && j <= i + 2) {
					System.out.printf("i: [%d], ignored j: [%d] \n", i, j);
					c = arrInput[j];
					continue;
				}
				
				char tmpC = arrInput[j];
				
				if(c == tmpC) {
					counter++;
					tmpPosition = j;
				}else {
					counter++;
					sb.append(counter).append(c);
					counter = 0; 
					c = tmpC;
				}
				System.out.printf("sb: [%s] \n", sb.toString());
			}
			System.out.printf("tmpPosition [%d], i: [%d], char [%c], counter: [%d] \n", tmpPosition, i, c, counter);
			if(tmpPosition < i || tmpPosition > i + 2) {
				sb.append(counter).append(c);
			}
			System.out.printf("sb: [%s], outLength: [%d], minCompressedInput: [%d] \n", sb.toString(), sb.length(), minCompressedInput);
			
			if(minCompressedInput > sb.length()) {
				minCompressedInput = sb.length();
			}
		}
		
		return minCompressedInput;
	}
}
