package com.interview.matrix.plan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointsPlane {

	public static void main(String[] args) {
		System.out.println("Input: ABB, output: " + solution("ABB", new int[] {1,-2,-2}, new int[] {1, -2, 2}));
		System.out.println("Input: ABDCA, output: " + solution("ABDCA", new int[] {2,-1,-4,-3,3}, new int[] {2,-2,4,1,-3}));
	}
	
	public static int solution(String input, int[] x, int[] y) {
		System.out.println();
		System.out.printf("\n input: [%s], x: [%s], y: [%s] \n", input, Arrays.toString(x), Arrays.toString(y));
		char[] arrayI = input.toCharArray();
		
		int limitBorder = 0;
		Map<Character, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < arrayI.length; i++) {
			char c = arrayI[i];
			int sumTmpPoints = Math.abs(x[i]) + Math.abs(y[i]);
			if(!hm.containsKey(c)) {
				if(limitBorder == 0 || sumTmpPoints < limitBorder) {
					hm.put(c, i);
					System.out.println("Not contains, hm: " +  hm.toString());
				}else {
					System.out.printf("Not added c: [%c], limitBorder: [%d], sumTmpPoints: [%d]", c, limitBorder, sumTmpPoints);
				}
				
			}else {
				//Get the closes to zero
				int existingIndex = hm.get(c);
				int existingX = x[existingIndex];
				int existingY = y[existingIndex];
				
				int sumExisting = Math.abs(existingX) + Math.abs(existingY);
				
				System.out.printf("char: [%c], sumExsiting: [%d], sumTmpPoints: [%d] \n", c, sumExisting, sumTmpPoints);
				
				if(sumExisting == sumTmpPoints) {
					hm.remove(c);
				}else {
					int minorValueIndex = sumExisting < sumTmpPoints ? existingIndex : i;
					hm.put(c, minorValueIndex);
				}
				
				if(limitBorder == 0) {
					limitBorder = sumExisting < sumTmpPoints ? sumTmpPoints : sumExisting;
				}else {
					limitBorder = limitBorder < sumExisting ? limitBorder : sumExisting;
				}
				
				
				List<Character> existingKeys = new ArrayList<>(hm.keySet());
				for(char savedChar: existingKeys) {
					int savedIndex = hm.get(savedChar);
					
					int savedValueSum = Math.abs(x[savedIndex]) + Math.abs(y[savedIndex]);
					if(limitBorder <= savedValueSum) {
						System.out.printf("Removed c: [%c], limitBorder: [%d], savedValueSum: [%d] \n", savedChar, limitBorder, savedValueSum);
						hm.remove(savedChar);
					}
				}
			}
		}
		
		System.out.println("Final hm: " +  hm.toString());
		return hm.size();
	}
	
}
