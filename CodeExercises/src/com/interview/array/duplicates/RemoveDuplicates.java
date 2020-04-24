package com.interview.array.duplicates;

public class RemoveDuplicates {

	public static void main(String[] args) {
		System.out.printf("len: [%d] \n", removeDuplicates(new int[] {1,1,2}));
		System.out.printf("len: [%d] \n", removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
		System.out.printf("len: [%d] \n", removeDuplicates(new int[] {1,1,2,2,2,2,2}));
		System.out.printf("len: [%d] \n", removeDuplicates(new int[] {1,1,1,1,1,1,1}));
	}
	
	public static int removeDuplicates(int[] nums) {
		int len = nums.length;
        if(nums == null || len == 0){
            return 0;
        }
        
        if(len == 1){
            return 1;
        }
        
        int head = 0;
        int count = 0;
        while(head < len) {
        	count++;
        	int previous = nums[head];
        	nums[count - 1] = previous;
        	while(head < len && previous == nums[head]) {
        		head++;
        	}
        }
        return count;
	}
	
	public static int countUniques(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0){
            return 0;
        }
        
        if(len == 1){
            return 1;
        }
        
        int head = 0;
        int count = 0;
        while(head < len) {
        	count++;
        	int previous = nums[head];
        	
        	while(head < len && previous == nums[head]) {
        		head++;
        	}
        }
        return count;
    }
}
