package com.mvp.learn.leetcode.solution.ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例：
 * 输入：s = "()"
 * 输出：true
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> q = new ArrayDeque<>();
        for (char ch : chars) {
            boolean left = (ch == '(') || (ch == '[') || (ch == '{');
            if (left) {
                // 左侧字符入栈
                q.push(ch);
            } else if (q.isEmpty() || !match(q.pop(), ch)) {
                return false;
            }
        }

        return q.isEmpty();
    }

    private boolean match(char l, char r) {
        return (l == '(' && r == ')') || (l == '{' && r == '}') || (l == '[' && r == ']');
    }

    public static void main(String[] args) {
        String s = "{{()()}[]}";
        ValidParentheses obj = new ValidParentheses();
        boolean result = obj.isValid(s);
        System.out.println("str= " + s);
        System.out.println("result=" + result);
    }
}
