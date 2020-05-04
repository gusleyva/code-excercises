package com.exercises.matrix.path.greatest;

import java.util.Arrays;

public class Product {

	public static void main(String[] args) {
		int[][] input = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		System.out.println(productSolution(input));
	}
	
	/**
	 * Positive integers
	 * @param matrix
	 * @return
	 */
	public static int productSolution(int[][] matrix) {
		int[][] solution = new int[matrix.length][matrix[0].length];
		
		printMatrix(matrix);
		
		for(int r = 0; r < matrix.length ; r++) {
			for(int c = 0; c < matrix[0].length; c++) {
				if(r == 0 && c == 0) {
					solution[r][c] = matrix[r][c];
				}else if(r == 0 || c == 0){ //borders
					if(r == 0) {
						solution[r][c] = solution[r][c - 1] * matrix[r][c];
					}else {
						solution[r][c] = solution[r -1 ][c] * matrix[r][c];
					}
				}else { //centers
					solution[r][c] = Math.max(solution[r][c - 1], solution[r - 1][c]) * matrix[r][c];
				}
			}
		}
		
		printMatrix(solution);
		
		return solution[matrix.length - 1][matrix[0].length - 1];
	}
	
	public static void printMatrix(int[][] input) {
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int[][] fillMatrix(int[][] input, int value) {
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[i].length; j++) {
				input[i][j] = -1;
			}
		}
		
		return input;
	}
}
