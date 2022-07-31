package com.mvp.learn.leetcode.solution.ThreeNumberSumCloset;

import java.util.Arrays;

/**
 * 16、给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * 示例 ：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class ThreeNumSumCloset {

    /***
     * 求三数之和最接近值
     *
     * @param nums 数组
     * @param target 目标值
     * @return 三数之和最接近值
     */
    public int threeSumClosest(int[] nums, int target) {
        // 对数组nums按从小到大排序
        Arrays.sort(nums);
        int result = 0;
        int total = nums.length;
        int diff = Integer.MAX_VALUE;
        int absDiff,threeSumCloset;
        for (int i = 0; i < total - 2; ++i) {
            int twoSumClosest = getTwoSumClosest(nums, i + 1, total - 1, target - nums[i]);
            threeSumCloset = twoSumClosest + nums[i];
            if (target == threeSumCloset) {
                return target;
            }

            absDiff = Math.abs(threeSumCloset - target);
            if (absDiff < diff) {
                result = threeSumCloset;
                diff = absDiff;
            }
        }

        return result;
    }

    /**
     * 求两数之和最接近值
     *
     * @param nums 数组
     * @param start 起始索引 inclusive
     * @param end 终止索引 exclusive
     * @param target 目标值
     * @return 两数之和最接近值
     */
    private int getTwoSumClosest(int[] nums, int start, int end, int target) {
        int result = 0;
        int tempSum, absDiff;
        int diff = Integer.MAX_VALUE;
        while (start < end) {
            tempSum = nums[start] + nums[end];
            if (tempSum == target) {
                return tempSum;
            }

            absDiff = Math.abs(tempSum - target);
            if (absDiff < diff) {
                result = tempSum;
                diff = absDiff;
            }

            if (tempSum < target) {
                ++start;
            } else {
                --end;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeNumSumCloset obj = new ThreeNumSumCloset();
        int[] nums = {0, 0, 0}; // {-1,2,1,-4}
        int target = 1;
        int result = obj.threeSumClosest(nums, target);
        System.out.println("nums= " + Arrays.toString(nums));
        System.out.println("targe= " + target);
        System.out.println("result= " + result);
    }
}
