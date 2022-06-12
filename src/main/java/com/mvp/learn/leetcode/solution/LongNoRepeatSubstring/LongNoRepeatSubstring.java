package com.mvp.learn.leetcode.solution.LongNoRepeatSubstring;

import org.apache.commons.compress.utils.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongNoRepeatSubstring {

    /**
     * 求取所有子串，然后计算最长子串。
     *
     * @param s 给定字符串
     * @return  最长子串长度
     */
    public int getLongestSubLengthForce(String s) {
        int answer = 0; // 无重复字符子串的最大长度
        String remainSubstring;
        List<String> substringList = Lists.newArrayList();
        StringBuilder currentSubString = new StringBuilder();
        for (int i = 0 ;  i < s.length(); i++) {
            char currentChar  = s.charAt(i);
            if (currentSubString.toString().contains(String.valueOf(currentChar))) {
                substringList.add(currentSubString.toString());
                remainSubstring = null; // 如果当前字符不是上一个当前子串的最后一个字符，则取该字符以后的子串
                if (currentSubString.lastIndexOf(String.valueOf(currentChar)) != (currentSubString.length() -1 )) {
                    remainSubstring = currentSubString.substring(currentSubString.lastIndexOf(String.valueOf(currentChar)) + 1);
                }
                currentSubString = new StringBuilder();
                if (remainSubstring != null) {
                    currentSubString.append(remainSubstring);
                }
            }
            currentSubString.append(currentChar);
        }

        for (String sub: substringList) {
//            System.out.println(sub);
            if (sub.length() > answer) {
                answer = sub.length();
            }
        }

        return answer;
    }

    /**
     * 滑动窗口法
     *
     * @param s 给定字符串
     * @return 最长子串长度
     */
    public int getLongestSubLengthWindow(String s) {
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
        String str = "abcddbacadbeeef";
//        str = "abcbac";
        int longestSubstring = obj.getLongestSubLengthWindow(str);
        System.out.println("滑动窗口法：" + longestSubstring);

        longestSubstring = obj.getLongestSubLengthForce(str);
        System.out.println("截取子串法：" + longestSubstring);
    }
}
