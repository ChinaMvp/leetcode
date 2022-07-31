package com.mvp.learn.leetcode.solution.TwoSumNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、已知两数之和，求加数。
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> value2IndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = target - nums[i];
            if (value2IndexMap.containsKey(num)) {
                return new int[]{value2IndexMap.get(num), i};
            }
            value2IndexMap.put(nums[i], i); // key为值，value为索引
        }
        return null;
    }

    public void showResultArray(int[] result) {
        if (null == result) {
            System.out.println("result is null");
            return;
        }

        for (int value : result) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {3, 2, 4};
        int target = 6;
        TwoSumSolution solution = new TwoSumSolution();
        int[] result = solution.twoSum(nums, target);
        solution.showResultArray(result);
    }
}
