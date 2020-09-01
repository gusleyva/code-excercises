package com.exercises.manipulation.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringUniqueChars {

	public int getLongestUniqueCharacterSubstring(String s) {
		int max = 0;
		int start = 0;
		int end = 0;
		Map<Character,Integer> combination = new HashMap<>();
		//"A B C A B A D E C"
		while(end < s.length()) {
	      //If the character has already been seen at a position after start, then update start
	      start = Math.max(start, combination.getOrDefault(s.charAt(end), 0));
	      combination.put(s.charAt(end), end + 1);
	      max = Math.max(end - start + 1, max);
	      end ++;
	    }
		
		return max;
	}
	
	public int getLongestSubstringUniqueChars(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int result = 0;
		int left = 0;
		int right = 0;
		while(left < n && right < n) {
			if(!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				right++;
				result = Math.max(result, right - left);
			}else {
				set.remove(s.charAt(left));
				left++;
			}
		}
		
		return 0;
	}
}
