package com.exercises.advance;

public class MaxProfit {

    public static void main(String[] args){
        int[] prices = new int[]{7,1,5,3,6,4};
        int min = prices[0];
        int max = 0;
        for(int idx = 1; idx < prices.length; idx++){
            min = Math.min(min, prices[idx]);
            max = Math.max(max, prices[idx] - min);

            System.out.printf("max: [%d], min: [%d], profit: [%d], current: [%d] \n", max, min, prices[idx] - min, prices[idx]);
        }
        System.out.println("max: " + max);
    }
}
