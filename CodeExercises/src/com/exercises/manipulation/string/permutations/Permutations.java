package com.exercises.manipulation.string.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		
		//System.out.println(p.permutations("abc"));
		//p.permutationsV2("", "abc");
		p.permutationsIterative("abc");
	}
	
	
	public void permutationsV2(String prefix, String suffix) {
		if(suffix.length() == 0) {
			System.out.println(prefix);
		}
		
		for(int i = 0; i < suffix.length(); i++) {
			String newPrefix = prefix + suffix.charAt(i); // "a" + b
			String newSuffix = suffix.substring(0, i) + //bc, ac
					suffix.substring(i+1);
			
			permutationsV2(newPrefix, newSuffix);
		}
		
	}
	
	// Iterative function to generate all permutations of a String in Java
	// using Collections
	public void permutationsIterative(String s)
	{
		// create an empty ArrayList to store (partial) permutations
		List<String> partial = new ArrayList<>();

		// initialize the list with the first character of the string
		partial.add(String.valueOf(s.charAt(0)));

		// do for every character of the specified string
		for (int i = 1; i < s.length(); i++)
		{
			// consider previously constructed partial permutation one by one

			// (iterate backwards to avoid ConcurrentModificationException)
			for (int j = partial.size() - 1; j >= 0 ; j--)
			{
				// remove current partial permutation from the ArrayList
				String str = partial.remove(j);

				// Insert next character of the specified string in all
				// possible positions of current partial permutation. Then
				// insert each of these newly constructed string in the list

				for (int k = 0; k <= str.length(); k++)
				{
					// Advice: use StringBuilder for concatenation
					partial.add(str.substring(0, k) + s.charAt(i) +
								str.substring(k));
				}
			}
		}

		System.out.println(partial);
	}
	
	
	public List<String> permutations(String s){
		List<String> results = new ArrayList<>();
		System.out.println("input: " + s);
		permutations("", s, results);
		return results;
	}
	/*
	 * 
	 * "", abc, {}
	 */
	public void permutations(String prefix, String suffix, List<String> results) {
		if(suffix.length() == 0) {
			results.add(prefix);
		}else {
			for(int i = 0; i < suffix.length(); i++) {
				String tmpPrefix = prefix + suffix.charAt(i);
				String tmpSuffix = suffix.substring(0, i);
				
				System.out.printf("tmpPrefix: [%s], tmpSuffix: [%s] \n", tmpPrefix, tmpSuffix);
				
				permutations(tmpPrefix,
						tmpSuffix, 
						results);
			}
		}
	}
}
