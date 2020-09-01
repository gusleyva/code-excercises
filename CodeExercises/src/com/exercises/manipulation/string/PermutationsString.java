package com.exercises.manipulation.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsString {

	public List<String> getPermutationsMatchesInString(String str1, String str2){
		
		List<String> result = new ArrayList<>();
		int[] str1Occurrences = new int[26];
		int[] str2Occurrences = new int[26];
		System.out.println("str1: " + str1 + ", str2: " + str2);
		for(int i = 0; i < str1.length(); i++) {
			// a, b
			//[0, 0, 0, 0, 0... n] 
			//[1, 1, 0...]
			str1Occurrences[str1.charAt(i) - 'a']++;
			str2Occurrences[str2.charAt(i) - 'a']++;
		}
		System.out.println("str1Occurrences: " + Arrays.toString(str1Occurrences));
		System.out.println("str2Occurrences: " + Arrays.toString(str2Occurrences));
		System.out.println("");
		int windowEnd = 0;
		while (windowEnd < str2.length() - str1.length()) {
			System.out.println("str2Occurrences: " + Arrays.toString(str2Occurrences));
			if (Arrays.equals(str1Occurrences, str2Occurrences)) {
				result.add(str2.substring(windowEnd, windowEnd + str1.length()));
			}
			str2Occurrences[str2.charAt(windowEnd) - 'a']--;
			str2Occurrences[str2.charAt(windowEnd + str1.length()) - 'a']++;
			windowEnd++;
		}
		if (Arrays.equals(str1Occurrences, str2Occurrences)) {
			result.add(str2.substring(windowEnd, windowEnd + str1.length()));
		}
		
		return result;
	}
}
