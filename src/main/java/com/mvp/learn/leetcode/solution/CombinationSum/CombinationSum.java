package com.mvp.learn.leetcode.solution.CombinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 39、组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
public class CombinationSum {
    private List<List<Integer>> rows;
    private int target;
    private int[] candidates;

    /**
     * 计算候选值组合累加和等于目标值的所有结果
     *
     * @param candidates 候选值列表
     * @param target 目标值
     * @return 候选值组合累加和等于目标值的所有结果
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rows = new ArrayList<>();
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
    private void dfs(int sum, int index, List<Integer> row) {
        if (sum == target) {
            rows.add(new ArrayList<>(row));
            return;
        }

        if (sum > target) {
            return;
        }

        int candidate;
        for (int i = index; i < candidates.length; ++i) {
            candidate = candidates[i];
            row.add(candidate);
            // 计算结果行(递归遍历)
            dfs(sum + candidate, i, row);
            row.remove(row.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        CombinationSum obj = new CombinationSum();
        List<List<Integer>> result = obj.combinationSum(candidates, target);
        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }
}