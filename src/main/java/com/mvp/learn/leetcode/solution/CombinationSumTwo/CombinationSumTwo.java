package com.mvp.learn.leetcode.solution.CombinationSumTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40、组合总和II
 * 题目描述
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSumTwo {
    private List<List<Integer>> rows;
    private int[] candidates;
    private int target;

    /**
     * 计算候选值组合累加和等于目标值的所有结果
     *
     * @param candidates 候选值列表
     * @param target 目标值
     * @return 候选值组合累加和等于目标值的所有结果
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rows = new ArrayList<>();
        Arrays.sort(candidates);
        this.target = target;
        this.candidates = candidates;
        // 计算结果行(递归遍历)
        dfs(0, 0, new ArrayList<>());
        return rows;
    }

    /**
     * 计算结果行(递归遍历)
     *
     * @param sum 当前和
     * @param index 当前候选值的索引
     * @param row 结果行
     */
    private void dfs(int index, int sum, List<Integer> row) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            rows.add(new ArrayList<>(row));
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            if ((i > index) && (candidates[i] == candidates[i - 1])) {
                continue;
            }

            row.add(candidates[i]);
            // 计算结果行(递归遍历)
            dfs(i + 1, sum + candidates[i], row);
            row.remove(row.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumTwo obj = new CombinationSumTwo();
        int[] candidates = {2, 3, 3, 5};
        int target = 8;
        List<List<Integer>> result = obj.combinationSum(candidates, target);
        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }
}
