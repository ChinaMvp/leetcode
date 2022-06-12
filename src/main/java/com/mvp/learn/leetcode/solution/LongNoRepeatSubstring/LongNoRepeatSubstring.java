package com.mvp.learn.leetcode.solution.LongNoRepeatSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongNoRepeatSubstring {

    public int getLongestSubstring(String s) {
        int left = 0; // 滑动窗口的左指针位置
        int right = 0; // 滑动窗口的右指针位置
        int answer = 0; // 无重复字符子串的最大长度
        Set<Character> charSet = new HashSet<>(); // 记录当前窗口内出现的字符
        for (int i = 0 ;  i < s.length(); i++) {
            char currentChar  = s.charAt(i);
            while (charSet.contains(currentChar)) {
                // 窗口减小
                charSet.remove(s.charAt(left));
                // 左指针向右移动
                ++left;
            }

            charSet.add(currentChar);
            answer = Math.max(answer, right - left + 1);
//            System.out.println("currentChar=" + currentChar + ", i=" +i + ", left=" + left + ", right=" + right + ", charSet=" + charSet.toString());
            ++right; // 右指针向右移动
        }
        return answer;
    }

    public static void main(String[] args) {
        LongNoRepeatSubstring obj = new LongNoRepeatSubstring();
        String str = "aabcabcbb";
//        str = "abcbac";
        int longestSubstring = obj.getLongestSubstring(str);
        System.out.println(longestSubstring);
    }
}
