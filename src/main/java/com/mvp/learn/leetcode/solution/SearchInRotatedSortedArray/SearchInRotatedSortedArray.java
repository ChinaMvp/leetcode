package com.mvp.learn.leetcode.solution.SearchInRotatedSortedArray;

import java.util.Arrays;


/**
 * 33、搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 */
public class SearchInRotatedSortedArray {

    /**
     * 获取目标值在数组中的索引
     *
     * @param nums 数组
     * @param target 目标值
     * @return 目标值在数组中的索引
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int middle = (left + right) >> 1;
            if (nums[0] <= nums[middle]) {
                // 对有序的一部分进行处理
                if ((nums[0] <= target) && (target <= nums[middle])) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            } else {
                // 对部分乱序的一部分进行处理
                if ((nums[middle] < target) && (target <= nums[n - 1])) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
        }

        return (nums[left] == target) ? left : -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = obj.search(nums, target);
        System.out.println("nums=" + Arrays.toString(nums));
        System.out.println("target=" + target);
        System.out.println("index=" + index);
        System.out.println();

        nums = new int[]{4, 5, 6, 7, 1, 2};
        target = 0;
        index = obj.search(nums, target);
        System.out.println("nums=" + Arrays.toString(nums));
        System.out.println("target=" + target);
        System.out.println("index=" + index);
    }
}