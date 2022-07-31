package com.mvp.learn.leetcode.solution.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 22、括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 ：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, n, "", result);
        return result;
    }

    private void dfs(int left, int right, int n, String pre, List<String> result) {
        if ((left == n) && (right == n)) {
            result.add(pre);
            return;
        }

        if (left < n) {
            dfs(left + 1, right, n, pre + "(", result);
        }
        if (right < left) {
            dfs(left, right + 1, n, pre + ")", result);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        int num = 3;
        List<String> result = obj.generateParenthesis(num);
        System.out.println("number= " + num);
        System.out.println("result= " + result.toString());
    }
}
