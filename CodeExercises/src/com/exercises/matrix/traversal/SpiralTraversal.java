package com.exercises.matrix.traversal;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

	public static void main(String[] args) {
		int[][] input = {
			{15,14,13,14},
			{40,50,60,12},
			{30,20,10,11}
		};
		System.out.println(solution(input).toString());
	}
	
	public static List<Integer> solution(int[][] matrix) {
		boolean rigth, down, left, up;
	    rigth = down = left = up = false;
	    
	    int lUp, lLeft;
	    lUp = lLeft = 0;
	    int lRigth = matrix[0].length;
	    int lDown = matrix.length;
	    int l = matrix.length * matrix.length;
	    rigth = true;
	    int i = 0;
	    int j = 0;
	    List<Integer> r = new ArrayList<>();
	    while(lUp < lDown && lLeft < lRigth){
	      System.out.println(r.toString());
	      r.add(matrix[i][j]);//1,2,3
	      if(rigth){
	        j++;
	        if(j == lRigth){
	          rigth = false;
	          down = true;
	          j--;
	          i++;
	          lUp++;
	        }
	      }else if(down){
	        i++;
	        if(i == lDown){
	          down = false;
	          left = true;
	          i--;
	          j--;
	          lRigth--;
	        }
	      }else if(left){
	        j--;
	        if(j < lLeft){
	          left = false;
	          up = true;
	          lDown--;
	          i--;
	          j++;
	        }
	      }else if(up){
	        i--;
	        if(i < lUp){
	          up = false;
	          rigth = true;
	          lLeft++;
	          j++;
	          i++;
	        }
	      }
	    }
	    return r;
		
	}
}
