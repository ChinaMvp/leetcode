package com.mvp.learn.leetcode.solution.RemoveDuplicatesSortedArray;

/**
 *
 */
public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if ((i == 0) || (num != nums[i - 1])) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3,4,4,5,6,6};
        RemoveDuplicatesSortedArray obj = new RemoveDuplicatesSortedArray();
        int length = obj.removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}
