package com.mvp.learn.leetcode.solution.FirstLastPositionInSortedArray;

import java.util.Arrays;

/**
 * 34、在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class FirstLastPositionInSortedArray {

    /**
     * 获取目标值在有序数组中的索引范围
     *
     * @param nums 有序数组
     * @param target 目标值
     * @return 索引范围
     */
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums, target + 1);
        return l == nums.length || l >= r ? new int[]{-1, -1} : new int[]{l, r - 1};
    }

    private int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = (left + right) >>> 1;
            if (nums[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        FirstLastPositionInSortedArray obj = new FirstLastPositionInSortedArray();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = obj.searchRange(nums, target);
        System.out.println("nums=" + Arrays.toString(nums));
        System.out.println("target=" + target);
        System.out.println("result=" + Arrays.toString(result));
    }
}
