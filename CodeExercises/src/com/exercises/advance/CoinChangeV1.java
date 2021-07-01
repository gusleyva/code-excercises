package com.exercises.advance;

public class CoinChangeV1 {

    public static void main(String args[]){
        int result = new CoinChangeV1().totalWaysToReachScore(12, new int[]{2,3,7});
        System.out.println("Result: " + result );
    }

    public int totalWaysToReachScore(int finalScore, int[] pointEvents) {
        int[][] cache = new int[pointEvents.length + 1][finalScore + 1];

        for(int col = 0; col <= finalScore; col++){
            cache[0][col] = 0;
        }

        for(int row = 0; row <= pointEvents.length; row++){
            cache[row][0] = 1;
        }

        for(int rows = 1; rows <= pointEvents.length; rows++){
            for(int cols = 1; cols <= finalScore; cols++){
                int event = pointEvents[rows - 1];

                int withOutEvent = cache[rows - 1][cols];

                int withEvent = 0;
                if(event <= cols){
                    withEvent = cache[rows][cols - event];
                }

                cache[rows][cols] = withOutEvent + withEvent;
            }
        }

        return cache[pointEvents.length][finalScore];
    }
}
