package com.exercises.matrix.rotation;

public class MatrixRotation {

	public static void main(String[] args) {
		int[][] x = {
			{10, 20},
			{30, 40},
		};
		
		printMatrix(x);
		System.out.println("");
		printMatrix(solution(x));
		
		int[][] x2 = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
			};
		printMatrix(x2);
		System.out.println("");
		printMatrix(solution(x2));
	}
	
	public static int[][] solution(int[][] x) {
		
		int[][] s = new int[x.length][x[0].length];
		
		int row = 0;
		int col = 0;
		
		for(int i = x.length - 1; i >= 0; i--) {
			for(int j = 0; j < x[0].length; j ++) {
				s[row][col] = x[i][j];
				row++;
			}
			row = 0;
			col++;
		}
		
		
		return s;
		
	}
	
	public static void printMatrix(int[][] x) {
		for(int i = 0; i < x.length; i++ ) {
			for(int j = 0; j < x[0].length; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}
}
