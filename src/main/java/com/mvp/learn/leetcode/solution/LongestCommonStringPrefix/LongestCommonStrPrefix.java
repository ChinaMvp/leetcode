package com.mvp.learn.leetcode.solution.LongestCommonStringPrefix;

import java.util.Arrays;

/**
 * 14、字符串数组最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 ：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 */
public class LongestCommonStrPrefix {

    public String longestCommonPrefix(String[] strs) {
        int total = strs.length;
        if (total == 0) {
            return "";
        }

        if (total == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < total; ++j) {
                if ((strs[j].length() <= i) || (strs[j].charAt(i) != strs[0].charAt(i))) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonStrPrefix obj = new LongestCommonStrPrefix();
//        String []strs = {"flower"};
        String []strs = {"flower","flow","flight"};
        String commonPrefix = obj.longestCommonPrefix(strs);
        System.out.println("strs=" + Arrays.toString(strs));
        System.out.println("commonPrefix=" + commonPrefix);
    }
}
