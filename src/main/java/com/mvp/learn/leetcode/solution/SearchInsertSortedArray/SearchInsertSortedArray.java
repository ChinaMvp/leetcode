package com.mvp.learn.leetcode.solution.SearchInsertSortedArray;

import java.util.Arrays;

/**
 * 35、搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */

public class SearchInsertSortedArray {
    /**
     * 获取目标值在有序数组中的位置或应该插入的位置。
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return 目标值在有序数组中的位置或应该插入的位置
     */
    private int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        SearchInsertSortedArray obj = new SearchInsertSortedArray();
        int[] nums = {1,3,5,6};
        int target = 5;
        int index = obj.searchInsert(nums, target);
        System.out.println("nums=" + Arrays.toString(nums));
        System.out.println("target=" + target);
        System.out.println("index=" + index);
        System.out.println();

        target = 2;
        index = obj.searchInsert(nums, target);
        System.out.println("nums=" + Arrays.toString(nums));
        System.out.println("target=" + target);
        System.out.println("index=" + index);
        System.out.println();

        target = 7;
        index = obj.searchInsert(nums, target);
        System.out.println("nums=" + Arrays.toString(nums));
        System.out.println("target=" + target);
        System.out.println("index=" + index);
    }
}
