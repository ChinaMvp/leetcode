package com.mvp.learn.leetcode.solution.TrappingRainWater;


import java.util.Arrays;

/**
 * 42、接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例1
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 *
 * 示例2
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 解法：
 * 动态规划法。
 * 对于下标 i，水能达到的最大高度等于"下标 i 左右两侧的最大高度的最小值 减去 height[i]"，就能得到当前柱子所能存的水量。
 */
public class TrappingRainWater {

    public int trap(int[] heights) {
        int length = heights.length;
        if (length < 3) {
            return 0;
        }

        // 对于下标 i 处的位置，leftMax[i]表示其左侧位置的最大高度，rightMax[i]表示其右侧位置的最大高度。
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        leftMax[0] = heights[0];
        rightMax[length - 1] = heights[length - 1];
        for (int i = 1; i < length; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
            rightMax[length - i - 1] = Math.max(rightMax[length - i], heights[length - i - 1]);
        }

        System.out.println("leftMax=" + Arrays.toString(leftMax));
        System.out.println("rightMax=" + Arrays.toString(rightMax));
        System.out.println("heights=" + Arrays.toString(heights));

        int result = 0;
        for (int i = 0; i < length; ++i) {
            result += (Math.min(leftMax[i], rightMax[i]) - heights[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        int[] heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = obj.trap(heights);
        System.out.println("result=" + result);
        System.out.println();

        heights = new int[]{4, 2, 0, 3, 2, 5};
        result = obj.trap(heights);
        System.out.println("result=" + result);
    }
}
