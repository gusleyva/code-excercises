package com.exercises.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinWeithPathTriangle {

    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = Arrays.asList(5);
        triangle.add(row);
        row = Arrays.asList(1,6);
        triangle.add(row);
        row = Arrays.asList(4,3,10);
        triangle.add(row);
        row = Arrays.asList(3,2,4,1);
        triangle.add(row);
        int min = new MinWeithPathTriangle().minimumPathCost(triangle);
        System.out.print("min: " + min);
    }

    public int minimumPathCost(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty())
            return 0;

        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        int[] cache = new int[lastRow.size()];
        System.out.println("lastRow: " + lastRow.toString());
        for(int idx = 0; idx < lastRow.size(); idx++){
            cache[idx] = lastRow.get(idx);
        }

        //List<Integer> path = new ArrayList<>();
        for(int idy = triangle.size() - 2; idy >= 0; idy--){
            List<Integer> currentRow = triangle.get(idy);
            System.out.println("currentRow: " + currentRow.toString());
            for(int idx = 0; idx < currentRow.size(); idx++){
                int current = currentRow.get(idx);
                int minPath = Math.min(current + cache[idx], current + cache[idx+1]);
                cache[idx] = minPath;
            }
            System.out.println("cache: " + Arrays.toString(cache));
        }
        return cache[0];
    }
}
