package com.exercises.stack.stonewall;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class StoneWall {

	public static void main(String[] args) {
		System.out.println("number blocks: " + solutionv2(new int[] {9,8,5,7,9,8,7,4,8}));
	}
	
	public static int solutionv2(int[] H) {
		// write your code in Java SE 8
        int blockCount = 0;
        Stack<Integer> stack = new Stack<>();
                            

        if(H.length == 1){
            return 1;
        } else if (H.length == 0){
            return 0;
        }
        
        for(int i= 0; i < H.length ; i++){
           
           while(!stack.isEmpty() && stack.peek() > H[i]) {
               stack.pop();        
           }
           
           if(stack.isEmpty()){
                stack.push(H[i]);
                blockCount++; 
           }
           
           if(!stack.isEmpty() && stack.peek() != H[i]){
             stack.push(H[i]);
             blockCount++;
           }
           
           
            
        }
        return blockCount;
    }
	
	public static int solution(int[] H) {
		System.out.println("Input: " + Arrays.toString(H));
		if(H == null || H.length == 0)
			return 0;
		
		if(H.length == 1)
			return 1;
		
		int numberBlocks = 1;
		Stack<Integer> s = new Stack<>();
		
		s.add(H[0]);
		for(int i = 1; i < H.length; i++) {
			int height = H[i];
			
			int previous = H[i - 1];
			while(!s.isEmpty() && previous > height) {
				previous = s.pop();
			}
			
			
			if(!s.isEmpty() && previous == height) { //At least previous should be same height
				continue;
			}else { //Is empty or less or greater
				numberBlocks++;
				s.add(height);
			}	
		}
		
		return numberBlocks;
	}
}
