package com.exercises.array.rearrange;

import java.util.Arrays;

public class DuplicateZeros {

	//[1,0,2,3,0,4,5,0]
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1,0,2,3,0,4,5,0})));
	}
	
	public static int[] solution(int[] input) {
		System.out.println(Arrays.toString(input));
		int[] output = new int[input.length];
		int i = 0;
		int j = 0;
		
		while(j < output.length) {
			int tmpNum = input[i];
			output[j] = tmpNum;
			if(tmpNum == 0) {
				j++;
				output[j] = tmpNum;
			}
			i++;
			j++;
		}
		
		for(int k = 0; k < input.length; k++) {
			input[k] = output[k];
		}
		return input; //output
	}
	
	public void solutionv2(int[] arr) {
	    int count = 0,i,k,j=0;
	    for(int x: arr){
	        if (x == 0)
	            count++;
	    }
	    int new_len = arr.length + count;
	    int[] A = new int[new_len];
	    for(i = 0 ; i < arr.length ; i++){
	        if(arr[i]==0){
	            A[j] = A[j+1] = 0;
	            j = j+2;
	        }else{
	            A[j]=arr[i];
	            j++;
	        }
	    }
	    for (k =0;k<arr.length;k++){
	        arr[k] = A[k];
	    }
	}
}
