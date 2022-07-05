package com.mvp.learn.leetcode.solution.NextPermutation;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class NextPermutation {
    /**
     * 获取数组的下一个排列。
     *
     * @param nums 数组
     */
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    // 对索引i + 1之后的元素进行升序排列。
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }

        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] nums = {1, 2, 3, 4, 1};
        System.out.println("Before: " + Arrays.toString(nums));
        obj.nextPermutation(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }
}
