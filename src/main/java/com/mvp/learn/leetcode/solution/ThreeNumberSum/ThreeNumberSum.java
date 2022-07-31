package com.mvp.learn.leetcode.solution.ThreeNumberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15、三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 示例 ：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class ThreeNumberSum {
    public List<List<Integer>> threeNumSum(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return Collections.emptyList();
        }

        // 对数组nums按从小到大排序
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; (i < length - 2) && (nums[i] <= 0); ++i) {
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }

            int j = i + 1, k = length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    while ((j < length) && (nums[j] == nums[j - 1])) {
                        ++j;
                    }
                    while ((k > i) && (nums[k] == nums[k + 1])) {
                        --k;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeNumberSum obj = new ThreeNumberSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = obj.threeNumSum(nums);
        System.out.println("result=" + result.toString());
    }
}
