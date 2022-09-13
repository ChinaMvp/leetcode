package com.mvp.learn.leetcode.solution.FirstMissingPositive;


import java.util.Arrays;

/**
 * 41、缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 *
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 * 解法
 * 无视空间需求，使用哈希表或数组来记录 nums 中所有出现过的正整数。然后，在其中查找 (1 ~ nums.length)，返回第一个不存在记录的正整数即可。
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        // 只关注正整数，对于正整数 x，将其归位到 nums[x - 1] 位置（与对应位置的元素进行交换）
        System.out.println("before adjust, array=" + Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] > 0) && (nums[i] < nums.length) && (nums[nums[i] - 1] != nums[i])) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        // 当所有的正整数归位之后，再次遍历 nums，找到第一个不满足 nums[i] != i + 1 表达式的位置，返回 i + 1。
        // 若是全部满足，则返回 nums.length + 1。
        System.out.println("before compute, array=" + Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                System.out.println("找到第一个不满足 nums[i] != i + 1 表达式的位置，返回 i + 1 =" + (i + 1));
                return i + 1;
            }
        }

        System.out.println("全部满足，则返回 nums.length + 1 =" + (nums.length + 1));
        return nums.length + 1;
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{30, 40, -10, 1};
        int[] nums = new int[]{1, 2, 0};
        FirstMissingPositive obj = new FirstMissingPositive();
        int result = obj.firstMissingPositive(nums);
        System.out.println("array=" + Arrays.toString(nums));
        System.out.println("result=" + result);
    }
}