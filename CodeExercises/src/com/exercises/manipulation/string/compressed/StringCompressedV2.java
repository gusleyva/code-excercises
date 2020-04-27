package com.exercises.manipulation.string.compressed;

public class StringCompressedV2 {

	public static void main(String[] args) {
		System.out.println("*** Input: ABBBCCDDCCC, minCompressedInput: " + solution("ABBBCCDDCCC", 3));
		System.out.println("*** Input: AAAAAAAAABXXAAAAAAAAAAAA, minCompressedInput: " + solution("AAAAAAAAABXXAAAAAAAAAAAA", 3));
	}
	
	public static int solution(String input, int k) {
		
		int minCompressedInput = input.length();
		
		int inputLength = input.length() - 1 ;
		System.out.println("Input: " + input);
		for(int i = 0; i <= inputLength; i++) { //
			int maxIndex = i + k;
			maxIndex = maxIndex <= inputLength ? maxIndex : inputLength;
			
			StringBuilder sb = new StringBuilder(input);
			sb.replace(i, maxIndex, "");
			
			String tmpInput = sb.toString();
			//System.out.printf("tmpInput: [%s] \n", tmpInput);
			
			char[] arrInput = tmpInput.toCharArray();
			char c = arrInput[0]; //Start at the beggining input
			StringBuilder finalSb = new StringBuilder();
			int counter = 1;
			
			for(int j = 1; j < arrInput.length; j++) {
				char tmpC = arrInput[j];
				
				if(c == tmpC) {
					counter++;
				}else {
					if(counter == 1) {
						finalSb.append(c);
					}else {
						finalSb.append(counter).append(c);
					}
					counter = 1; 
					c = tmpC;
				}
				//System.out.printf("finalSb: [%s] \n", finalSb.toString());
			}
			
			if(counter == 1) {
				finalSb.append(c);
			}else {
				finalSb.append(counter).append(c);
			}
			System.out.printf("finalSb: [%s] \n", finalSb.toString());
			
			if(minCompressedInput > finalSb.length()) {
				minCompressedInput = finalSb.length();
			}
		}
		
		return minCompressedInput;
	}
}
