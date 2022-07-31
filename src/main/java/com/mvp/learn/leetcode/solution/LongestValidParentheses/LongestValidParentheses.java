package com.mvp.learn.leetcode.solution.LongestValidParentheses;

import java.util.Stack;

/**
 * 32、字符串中最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 */
public class LongestValidParentheses {
    /**
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int start = 0; // 当前起始下标
        int startIndex = 0; // 有效括号子串的起始下标
        int maxlength = 0; // 有效括号子串的长度
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals("(")) {
                // 若当前字符为左括号，则将其下标入栈
                stack.push(i);
                continue;
            } else {
                // 若当前字符为右括号，则：
                if (stack.empty()) {
                    // 若栈空，则"当前起始下标"为"当前字符的下一个字符的下标"。
                    start = i + 1;
                } else {
                    // 若栈非空，则该右括号找到匹配的左括号，出栈。
                    stack.pop();
                    if (stack.empty()) {
                        maxlength = Math.max(maxlength, i - start + 1);
                        if (maxlength == i - start + 1) {
                            startIndex = start;
                        }
                    } else {
                        maxlength = Math.max(maxlength, i - stack.peek());
                        if (maxlength == i - stack.peek()) {
                            startIndex = stack.peek();
                        }
                    }
                }
            }
        }

        System.out.println("startIndex= " + startIndex);
        System.out.println("maxlength= " + maxlength);
        System.out.println("valid parentheses=" + s.substring(startIndex, startIndex + maxlength));
        return maxlength;
    }

    public static void main(String[] args) {
        String s = ")()())";
        LongestValidParentheses obj = new LongestValidParentheses();
        int parenthesesLength = obj.longestValidParentheses(s);
        System.out.println("parenthesesLength=" + parenthesesLength);
    }
}
