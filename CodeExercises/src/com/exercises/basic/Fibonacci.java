package com.exercises.basic;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.printf("Input: 1, Expected fibo output: 1, output: [%d] \n", fibonacci(1));
		System.out.printf("Input: 2, Expected fibo output: 1, output: [%d] \n", fibonacci(2));
		System.out.printf("Input: 3, Expected fibo output: 2, output: [%d] \n", fibonacci(3));
		System.out.printf("Input: 4, Expected fibo output: 3, output: [%d] \n", fibonacci(4));
		System.out.printf("Input: 5, Expected fibo output: 5, output: [%d] \n", fibonacci(5));
		System.out.printf("Input: 6, Expected fibo output: 8, output: [%d] \n", fibonacci(6));
		System.out.printf("Input: 7, Expected fibo output: 13, output: [%d] \n", fibonacci(7));
		System.out.printf("Input: 8, Expected fibo output: 21, output: [%d] \n", fibonacci(8));
		System.out.println("===============================");
		Fibonacci fibo = new Fibonacci();
		System.out.printf("Input: 1, Expected fibo output: 1, output: [%d] \n", fibo.fibonacciRecursive(1, 1, 0, 1));
		System.out.printf("Input: 2, Expected fibo output: 1, output: [%d] \n", fibo.fibonacciRecursive(2, 2, 0, 1));
		System.out.printf("Input: 3, Expected fibo output: 2, output: [%d] \n", fibo.fibonacciRecursive(3, 2, 0, 1));
		System.out.printf("Input: 4, Expected fibo output: 3, output: [%d] \n", fibo.fibonacciRecursive(4, 2, 0, 1));
		
		System.out.println("===============================");
		Map<Integer, Integer> cache = new HashMap<>();
		System.out.printf("Input: 1, Expected fibo output: 1, output: [%d] \n", fibo.fibonacciRecursiveV2(1, cache));
		System.out.printf("Input: 2, Expected fibo output: 1, output: [%d] \n", fibo.fibonacciRecursiveV2(2, cache));
		System.out.printf("Input: 3, Expected fibo output: 2, output: [%d] \n", fibo.fibonacciRecursiveV2(3, cache));
		System.out.printf("Input: 4, Expected fibo output: 3, output: [%d] \n", fibo.fibonacciRecursiveV2(4, cache));
		System.out.printf("Input: 5, Expected fibo output: 5, output: [%d] \n", fibo.fibonacciRecursiveV2(5, cache));
		System.out.printf("Input: 6, Expected fibo output: 8, output: [%d] \n", fibo.fibonacciRecursiveV2(6, cache));
		
	}
	
	public static int fibonacci(int num) {
		if(num == 0 || num == 1) {
			return num;
		}
		
		int prev = 0;
		int fiboSum = 1;
		for(int i = 2; i <= num; i++) { //2,1 -> 3,2 -> 4, 3 -> 5,5 -> 6, 8 
			int tmpPrev = fiboSum; //1
			fiboSum = fiboSum + prev; // 1 + 0 = 1
			prev = tmpPrev; //3
		}
		
		return fiboSum;
	}
	
	/**
	 * 6 = 5 + 4 -> 5 + 3 (cache.get(4)) = 8
	 * 5 = 4 + 3 -> 3 + 2 (cache.get(3)) = 5
	 * 4 = 3 + 2 -> 2 + 1 (cache.get(2)) = 3
	 * 3 = 2 + 1 -> 1 + return 1 = 2 
	 * 2 = 1 + 0 -> return 1
	 */
	public int fibonacciRecursiveV2(int n, Map<Integer, Integer> cache) {//3, 
		if( n == 0 || n == 1) {
			return n;
		} else {
			if(cache.containsKey(n)) {
				return cache.get(n);
			}else {
				int sum = fibonacciRecursiveV2(n - 1, cache) + fibonacciRecursiveV2(n - 2, cache);
				cache.put(n, sum);
				return sum;
			}
		}
	}
	
	public int fibonacciRecursive(int num, int count, int prev, int sum) {
		if(num == 0 || num == 1) {
			return num;
		}
		
		if(count > num)
			return sum;
		
		int tmpPrev = sum;
		sum += prev;
		prev = tmpPrev;
		count++;
		return fibonacciRecursive(num, count, prev, sum);
	}
	
}
