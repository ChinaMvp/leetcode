package com.mvp.learn.leetcode.solution.FourNumberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 18. 四数之和
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 示例 ：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class FourNumberSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int total = nums.length;
        if (total < 4) {
            return Collections.emptyList();
        }

        // 对数组nums按从小到大排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < total - 3; ++i) {
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }

            for (int j = i + 1; j < total - 2; ++j) {
                if ((j > i + 1) && (nums[j] == nums[j - 1])) {
                    continue;
                }

                int k = j + 1, l = total - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        ++k;
                        --l;
                        while ((k < total) && (nums[k] == nums[k - 1])) {
                            ++k;
                        }
                        while ((l > j) && (nums[l] == nums[l + 1])) {
                            --l;
                        }
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        ++k;
                    } else {
                        --l;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FourNumberSum obj = new FourNumberSum();
        int []nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> result = obj.fourSum(nums, target);
        System.out.println("nums= " + Arrays.toString(nums));
        System.out.println("target= " + target);
        System.out.println("result= " + result.toString());
    }
}