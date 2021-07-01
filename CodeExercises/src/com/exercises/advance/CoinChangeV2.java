package com.exercises.advance;

import java.util.Arrays;

public class CoinChangeV2 {
    public static void main(String args[]){
        int result = new CoinChangeV2().leastCoins(new int[]{1,2,3}, 10);
        System.out.println("Result: " + result);
    }

    public int leastCoins(int[] coins, int amount) {

        int[] cache = new int[amount + 1];

        Arrays.fill(cache, amount + 1);

        cache[0] = 0;

        for(int idx = 1; idx < cache.length; idx++){
            for(int coin: coins){
                if(coin > idx){ //
                    continue;
                }
                int position = idx - coin;
                System.out.printf("idx: [%d], cache[idx]: [%d], pos: [%d], cache[pos]: [%d], Cache: [%s] \n",
                        idx, cache[idx], position, cache[position], Arrays.toString(cache));
                cache[idx] = Math.min(cache[position] + 1, cache[idx]);
            }
        }

        return cache[amount];
    }
}
