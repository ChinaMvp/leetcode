package com.mvp.learn.leetcode.solution.ContainerMostWater;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int result = 0;
        while (i < j) {
            int t = (j - i) * Math.min(height[i], height[j]);
            result = Math.max(result, t);
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();

        int[] height = {1,8,6,2,5,4,8,3,7};
        int area = obj.maxArea(height);
        System.out.println("area=" + area);
    }
}
