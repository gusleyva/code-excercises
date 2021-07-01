package com.exercises.search;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] input = new int[]{4,1,9,6,3,5};
        System.out.println(Arrays.toString(input));
        quickSortRecursive(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    /**
     * QuickSort is a Divide and conquer algorithm
     */
    static void quickSortRecursive(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSortRecursive(arr, begin, partitionIndex-1);
            quickSortRecursive(arr, partitionIndex+1, end);
        }
    }

    static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int idx = (begin - 1);
        for (int idy = begin; idy < end; idy++) {
            //All smallest numbers to the left, ignore everything that is bigger than pivot in the first round
            if(arr[idy] <= pivot) {
                idx++;

                int swapTemp = arr[idx];
                arr[idx] = arr[idy];
                arr[idy] = swapTemp;
            }
        }
        //Set the pivot to the next item in the array
        int swapTemp = arr[idx + 1];
        arr[idx + 1] = arr[end];
        arr[end] = swapTemp;

        return idx + 1;
    }
}
