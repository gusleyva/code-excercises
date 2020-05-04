package com.exercises.matrix.squaresubmatrix;

public class SquareSubMatrix {

	public static void main(String[] args) {
		int[][] input = {
				{1,1,1,0},
				{1,1,1,1},
				{1,0,1,0},
				{0,1,0,1}
		};
		
		System.out.println(solution(input));
		
		int[][] input2 = {
				{1,0,1,0},
				{1,1,1,1},
				{1,1,1,1},
				{0,1,1,1}
		};
		
		System.out.println(solution(input2));
	}
	
	public static int solution(int[][] input) {
		int max = 0;
		int x = input.length;
		int y = input[0].length;
		
		int[][] solution = new int[x][y];
		
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				System.out.printf("i: [%d], j: [%d], input: [%d] \n", i, j, input[i][j]);
				if(i == 0 || j == 0) {
					solution[i][j] = input[i][j];
				}else if(input[i][j] == 1) {
					
					solution[i][j] = Math.min(
							Math.min(solution[i][j-1], solution[i-1][j])
							, solution[i-1][j-1]) + 1;
				}
				
				if(solution[i][j] > max) {
					max = solution[i][j];
				}
				
				System.out.printf("i: [%d], j: [%d], solution: [%d] \n", i, j, solution[i][j]);
			}
			System.out.println("Max: " + max);
		}
		
		
		return max;
	}
}
