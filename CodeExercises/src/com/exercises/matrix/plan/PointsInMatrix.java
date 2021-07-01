package com.exercises.matrix.plan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PointsInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static int solution(String s, int[] x, int[] y) {
		Map<String, Long> numberRepetition = PointsInMatrix.getNumberRepetition(s);
		if(numberRepetition.size() == s.length()) {
			return s.length(); //Should be return number of points?
		}
		
		List<Map<Character, Integer>> pointsPlane = new ArrayList<>();
		
		Map<Character, Integer> values;
		for(int idx = 0; idx < s.length(); idx++) {
			values = new HashMap<Character, Integer>();
			values.put(s.charAt(idx), getPointHypotenuse(x[idx], y[idx]));
			pointsPlane.add(values);
		}
		
		return 0;
	}
	
	/**
	 * calculate the distance of each point from the center of the plane by using Pythagorean theorem
	 * a^2 + b^2 = c^2
	 */
	public static int getPointHypotenuse(int x, int y) {
		return (int)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public static Map<String, Long> getNumberRepetition(String input) {
		return input
				.chars()
				.mapToObj(idx -> (char)idx)
				.collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
	}

}
