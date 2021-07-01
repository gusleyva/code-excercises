package com.exercises.advance;

public class Knapsack {
    public static void main(String args[]){
        int result = new Knapsack().solutionBottomUp(
                new int[]{60,50,70,30},
                new int[]{5,3,4,2},
                8);
        System.out.println("Result: " + result );
    }

    public int solutionBottomUp(int[] values, int[] weights, int maxWeightConstraint) {
        int[][] cache = new int[values.length + 1][maxWeightConstraint + 1];

        for(int item = 0; item <= values.length; item++){
            for(int maxWeight = 0; maxWeight <= maxWeightConstraint; maxWeight++){
                if(item == 0 || maxWeight == 0){
                    cache[item][maxWeight] = 0;
                } else {
                    int currentWeight = weights[item - 1];
                    if(currentWeight > maxWeight){ //5 = 5
                        cache[item][maxWeight] = cache[item - 1][maxWeight]; //dont use the itemem
                    }else{
                        int currentValue = values[item -1];
                        //dont use item, use item = currentValue + (rowUp previous value)
                        cache[item][maxWeight] = Math.max(cache[item - 1][maxWeight], currentValue + cache[item - 1][maxWeight - currentWeight]);
                    }
                }
            }
        }

        return cache[values.length][maxWeightConstraint];
    }

    public int solutionBottomUpBackToBack(int[] values, int[] weights, int maxWeightConstraint){
        int[][] cache = new int[values.length +1][maxWeightConstraint + 1]; //[5][9]

        //totalitemems <= 5
        for(int totalitemems = 0; totalitemems <= values.length; totalitemems++){
            for(int maxWeight = 0; maxWeight <= maxWeightConstraint; maxWeight++){
                int currentitemem = totalitemems - 1; //-1,0...

                if(totalitemems == 0 || maxWeight == 0){
                    cache[totalitemems][maxWeight] = 0;
                } else if (weights[currentitemem] > maxWeight){
                    cache[totalitemems][maxWeight] = cache[totalitemems - 1][maxWeight]; //
                } else {
                    int witemhitemem = values[currentitemem] + cache[totalitemems -1][maxWeight - weights[currentitemem]];
                    int witemhoutitemem = cache[totalitemems - 1][maxWeight];

                    cache[totalitemems][maxWeight] = Math.max(witemhitemem, witemhoutitemem);
                }

            }
        }
        return cache[values.length][maxWeightConstraint];
    }

    public int knapsackTopDown(
        int[] values,
        int[] weights,
        int maxWeightConstraint,
        int totalItems,
        int[][] cache
    ){
        if(totalItems == 0 || maxWeightConstraint == 0){
            return 0;
        }

        if(cache[totalItems][maxWeightConstraint] != 0){
            return cache[totalItems][maxWeightConstraint];
        }

        int currentItemIndex = totalItems - 1;

        if(weights[currentItemIndex] > maxWeightConstraint){
            cache[totalItems][maxWeightConstraint] =
               knapsackTopDown(values, weights, maxWeightConstraint, totalItems - 1, cache);

            return cache[totalItems][maxWeightConstraint];
        }

        int withItem = values[currentItemIndex] +
            knapsackTopDown(
                values,
                weights,
                maxWeightConstraint - weights[currentItemIndex],
                totalItems - 1,
                cache
            );

        int withoutItem = knapsackTopDown(
                values,
                weights,
                maxWeightConstraint - weights[currentItemIndex],
                totalItems - 1,
                cache
        );

        cache[totalItems][maxWeightConstraint] = Math.max(withItem, withoutItem);

        return cache[totalItems][maxWeightConstraint];
    }
}
