package com.exercises.manipulation.string.palindrome;

public class LongesSubstringPalindrome {

	public static void main(String[] args) {
		String input1 = "racecar";
		String input2 = "abccba";
		System.out.print(solution(input1));
		//System.out.print(solution(input2));
	}
	
	public static String solution(String s) {
		if(s == null || s.length() <= 1)
			return s;
		
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < s.length(); i++) {
			int len1 = expandFromTheMiddle(s, i, i);
			int len2 = expandFromTheMiddle(s, i, i + 1);
			int maxLen = Math.max(len1, len2);
			if(maxLen > (end - start)) {
				start = i - ((maxLen - 1) / 2);
				end = i + (maxLen / 2);
			}
			System.out.printf("Start: [%d], end: [%d] \n", start, end);
		}
		return s.substring(start, end + 1);
	}
	
	public static int expandFromTheMiddle(String s, int left, int right) {
		if(s == null) return 0;
		
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		
		return right - left - 1; //Full word it needs to consider the indexes (racecar = 6 letters, 5 length)
	}
}
