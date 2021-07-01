package com.exercises.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3};
        System.out.println(binarySearchRecursive(input, 1, 0, input.length - 1));
        System.out.println(binarySearch(input, 1));
        System.out.println(binarySearch(input, 2));
        System.out.println(binarySearch(input, 3));
        System.out.println(binarySearch(input, 6));
        //System.out.println(runBinarySearchIteratively(input, 3));

        input = new int[]{1,3,4,5};
        System.out.println(binarySearch(input, 1));
        System.out.println(binarySearch(input, 3));
        System.out.println(binarySearch(input, 4));
        System.out.println(binarySearch(input, 2));
    }
    /**
     * [1,2,3,4,5,6,7,8,9,10]
     */
    static boolean binarySearch(int[] arr, int num){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int middle = (low + high) / 2;
            if(num == arr[middle])
                return true;

            if(arr[middle] < num) {
                low = middle + 1;
            } else{
                high = middle - 1;
            }
        }
        return false;
    }

    static boolean binarySearchRecursive(int[] arr, int num, int low, int high){
        if(low > high)
            return false;
        int middle = (low + high) / 2;
        if(arr[middle] == num)
            return true;

        if(arr[middle] < num){
            low = middle + 1;
        } else {
            high = middle - 1;
        }
        return binarySearchRecursive(arr, num, low, high);
    }

    static boolean runBinarySearchIteratively(
            int[] sortedArray, int key) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                return true;
            }
        }
        return false;
    }
}
