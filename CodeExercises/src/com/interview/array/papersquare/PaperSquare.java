package com.interview.array.papersquare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given two paper strips. On each strip, numbers (1, 2, ... N) are written in random order. Cut the original paper strip into several pieces and rearrange those pieces to form the desired sequence.
Write a function that, efficiently with respect to time used, returns the minimum number of cut pieces needed to perform the described operation.
For example, the following code should display 3 because the pieces used should be (1), (4, 3), and (2):

if they are subsequent, (4, 3), count 1
 * @author gleyvaca
 *
 */

public class PaperSquare {

	public static void main(String[] args) {
		int[] desired = new int[] { 1, 2, 4, 3 };
		int[] original = new int[] { 1, 4, 3, 2 };
		
		System.out.println("Number of paper strips: " + solution(desired, original));
		
	}
	
	public static int solution(int[] desired, int[] original) {
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(desired));
		
		List<Integer> tmpList = new ArrayList<>();
		int paperStripCounter = 1;
		
		int i = 0;
		int j = 0;
		StringBuilder sb = new StringBuilder();
		while(i < original.length && j < desired.length) {
			int tmpO = original[i];
			int tmpD = desired[j];
			
			if(tmpO == tmpD) {
				i++;
				j++;
				sb.append(tmpO).append(",");
			} else {
				tmpList.add(tmpD);
				j++;
				sb.append("|");
				paperStripCounter++;
			}
		}
		
		for(int tmp : tmpList) {
			sb.append("|").append(tmp).append("|");
			paperStripCounter++;
		}
		
		System.out.println(sb.toString());
		
		return paperStripCounter;
	}
}
