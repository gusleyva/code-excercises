package com.exercises.array.sum;

public class SumFunction {
    public static void main(String[] args) {
        int[] input = new int[]{2,4,6};
        int[] input2 = new int[]{1,2,3,4,5,6};
        System.out.println(sumRecursive(input2, 0));

        System.out.println(sumRecursiveFromEnd(input2, input2.length));
    }

    static int sumRecursive(int[] input, int idx) {
        if(input.length - 1 == idx) //4 - 4 = 0 < 0
            return input[idx];

        return input[idx] + sumRecursive(input, ++idx);
    }

    static int sumRecursiveFromEnd(int[] input, int idx) {
        if(idx <= 0)
            return 0;

        return (sumRecursiveFromEnd(input, idx - 1) + input[idx - 1]);
    }
}
