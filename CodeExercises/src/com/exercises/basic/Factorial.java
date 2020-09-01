package com.exercises.basic;

import java.util.HashMap;
import java.util.Map;

public class Factorial {
	public static void main(String[] args) {
		Factorial fac = new Factorial();
		System.out.println("" + fac.Factorial(6));
		System.out.println("===============================");
		System.out.println("" + fac.factorialRecursive(6));
		System.out.println("===============================");
		Map<Integer,Integer> cache = new HashMap<>();
		System.out.println("" + fac.factorialRecursiveCache(6, cache));
		
	}
	
	private int Factorial(int n) {
		if(n == 0)
			return 1;
		
		int count = 1;
		int sum = 1;
		
		while(count <= n) { //2 <= 2
			sum = sum * count; //24 * 5 = 120
			count++; //3
		}
		return sum;
	}
	
	/**
	 * 3! = 3 * 2! = 3 * 2 = 6
	 * 2! = 2 * 1! = 2 * 1 = 2
	 * 1! = 1
	 */
	private int factorialRecursive(int n) {
		if(n == 0 || n == 1)
			return 1;
		
		return n * factorialRecursive(n - 1);
	}
	
	private int factorialRecursiveCache(int n, Map<Integer, Integer> cache) {
		if(n == 0)
			return 1;
		if(cache.containsKey(n)) {
			return cache.get(n);
		}else {
			int result = factorialRecursiveCache(n - 1, cache);
			System.out.print(result + ", ");
			return n * result;
		}
	}
}
