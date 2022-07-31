package com.mvp.learn.leetcode.solution.RemoveArrayElement;

/**
 * 27、数组移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveArrayElement {

    /**
     * 获取移除指定元素后数组的长度
     *
     * @param nums 数组
     * @param value 被移除元素值
     * @return 移除指定元素后数组的长度
     */
    public int removeElement(int[] nums, int value) {
        int cnt = 0, length = nums.length;
        for (int i = 0; i < length; ++i) {
            if (nums[i] == value) {
                ++cnt;
            } else {
                nums[i - cnt] = nums[i];
            }
        }

        return length - cnt;
    }

    public static void main(String[] args) {
        RemoveArrayElement obj = new RemoveArrayElement();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int value = 2;
        int length = obj.removeElement(nums, value);
        for (int i=0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}