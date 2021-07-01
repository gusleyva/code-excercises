package com.exercises.advance;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DecodeWays {
    public static void main(String args[]){
        int result = new DecodeWays().decodeWays("123");
        System.out.println("Result: " + result);
    }

    public int decodeWays(String s) {
        int[] dp = new int[s.length()]; //Collect answers to subProblems
        Arrays.fill(dp, -1);
        return decodeWord(s, 0, dp);
    }

    private int decodeWord(String s, int position, int[] dp){
        if(position >= s.length()){
            return 1; //Decomposition finish
        }

        if(dp[position] > -1){ //Change from exponential to constant time
            return dp[position];
        }

        int totalDecomposition = 0;
        for(int i = 1; i <= 2; i++){
            if(position + i <= s.length()){
                String snippet = s.substring(position, position + i); //substring is a new object in memory
                System.out.println("position: " + position + ", snippet: " + snippet + ", dp: " + Arrays.toString(dp));
                if(isValid(snippet)){
                    totalDecomposition += decodeWord(s, position + i, dp); //State of change = consume 1 char or 2
                }
            }
        }

        //Record subprogram answer to decomposition from (position) .... (s.length -1)
        dp[position] = totalDecomposition;
        System.out.println("position: " + position + ", dp: " + Arrays.toString(dp));
        return dp[position];
    }

    private boolean isValid(String s){
        if(s.length() == 0 || s.charAt(0) == '0'){
            return false;
        }

        int value = Integer.parseInt(s);

        return value >= 1 && value <= 26;
    }
}
