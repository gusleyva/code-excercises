package com.exercises.manipulation.string.compressed;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StringCompressedV3 {
	
	public static void main(String[] args) {
		int result = StringCompressedV3.findCompressedLength("AAAAAAAAAAABXXAAAAAAAAAA", 3);
		System.out.println("Result: " + result); // Expected 3 -> 21A
		
		result = StringCompressedV3.findCompressedLength("GGGGG", 3);
		System.out.println("Result: " + result); // Expected 2 -> 5G
		
		result = StringCompressedV3.findCompressedLength("BCCCDDEEDDD", 0);
		System.out.println("Result: " + result); // Expected 9 -> B3C2D2E3D
		
		result = StringCompressedV3.findCompressedLength("ZZZZZZZZZZZATTZZZZZZZZZZ", 1);
		System.out.println("Result: " + result); // Expected 2 -> 11ZA2T10Z
	}
	
	
	public static int findCompressedLength(String s, int k) {
		System.out.println("Input: " + s + ", k: " + k);
		
		//Boundary cases
		if(s.length() < 3)
			return s.length();
		else if(k > s.length() - 1)
			return s.length() + 1;
		
		Map<Character, Integer> charsWithFrequencie = new HashMap<Character, Integer>();
		
		int windowStart = 0;
		int longestSequence = 0;
		int repetitions = 0;
		LongestSequenceInstance longestSequenceInstance = new LongestSequenceInstance();
		
		for(int idx = 0; idx < s.length(); idx++) {
			char currentLetter = s.charAt(idx);
			if(charsWithFrequencie.containsKey(s.charAt(idx))) {
				charsWithFrequencie.put(currentLetter, charsWithFrequencie.get(currentLetter) + 1);
			} else {
				charsWithFrequencie.put(currentLetter, 1);
			}
			
			repetitions = charsWithFrequencie.get(currentLetter);
			
			/**
			 * Then you add a condition which checks of the distance from 
			 * current index to the beginning of the window – number of the 
			 * current letter repetitions + 1 (because length is denoted in 0 based convention) is bigger 
			 * than the number of allowed letter replacement (K). 
			 * Please take your time to wrap your mind around it.
			 */
			if(idx - windowStart - repetitions + 1 > k) {
				charsWithFrequencie.put(currentLetter, charsWithFrequencie.get(currentLetter) - 1);
				windowStart++;
			}
			
			/**
			 * Now, since we know that the algorithm is going to return the longest sequence, 
			 * each time it’s saving this sequence, let’s save few more properties:
			 */
			if(idx - windowStart + 1 > longestSequence) {
				longestSequence = idx - windowStart + 1;
				longestSequenceInstance.endingIndex = idx;
				longestSequenceInstance.startingIndex = idx - longestSequence + 1;
				longestSequenceInstance.letter = currentLetter;
				longestSequenceInstance.occurrences = longestSequence;
			}
			
		}
		
		/**
		 * var replaced = workingString.Remove(longestSequenceInstance.StartingIndex, longestSequenceInstance.Occurences - 1)
                                .Insert(longestSequenceInstance.StartingIndex, 
                                	String.Concat(Enumerable.Repeat(longestSequenceInstance.Letter, longestSequenceInstance.Occurences-1)))
                                .ToString();
		 */
		
		StringBuilder sb = new StringBuilder(s);
		/**
		 * delete(start, end)
		 * - start − This is the beginning index, inclusive.
		 * - end − This is the ending index, exclusive.
		 */
		//longestSequenceInstance.getLetter().toString().rep;
		// create a string made up of n copies of string s
		//String.join("", Collections.nCopies(longestSequenceInstance.occurrences - 1, longestSequenceInstance.getLetter().toString()));
		
		String replaced = sb.delete(longestSequenceInstance.startingIndex, longestSequenceInstance.occurrences - 1)
					.insert(longestSequenceInstance.startingIndex,
							String.join("", Collections.nCopies(longestSequenceInstance.occurrences - 1, longestSequenceInstance.getLetter().toString()))
					).toString();
		
		//Final count func
		
		int occurences = 1;
	    char currentChar;
	    StringBuilder strBuilder = new StringBuilder("");

	    for (int i = 1; i < replaced.length(); i++) {
	    	currentChar = replaced.charAt(i);
	    	
	    	if (replaced.charAt(i - 1) == replaced.charAt(i)) {
	    		occurences++;
	    	} else{
	    		if (occurences > 1) {
	    			strBuilder.append(occurences);
	    		}
	    		strBuilder.append(replaced.charAt(i - 1));
	    		occurences = 1;
	      }

	      if (i == replaced.length() - 1) {
	        if (occurences > 1) {
	        	strBuilder.append(occurences);
	        }
	 
	        strBuilder.append(currentChar);
	      }
	    }

	    String stringFinal = strBuilder.toString();
	    
	    System.out.println("stringFinal: " + stringFinal);
	    return stringFinal.length();
	}

}

class LongestSequenceInstance {
	public Character letter;
	public int endingIndex;
	public int startingIndex;
	public int occurrences;
	
	public Character getLetter() {
		return letter;
	}
	
	public void setLetter(Character letter) {
		this.letter = letter;
	}
	
	public int getEndingIndex() {
		return endingIndex;
	}
	
	public void setEndingIndex(int endingIndex) {
		this.endingIndex = endingIndex;
	}
	
	public int getStartingIndex() {
		return startingIndex;
	}
	
	public void setStartingIndex(int startingIndex) {
		this.startingIndex = startingIndex;
	}
	
	public int getOccurrences() {
		return occurrences;
	}
	
	public void setOccurrences(int occurrences) {
		this.occurrences = occurrences;
	}
}
