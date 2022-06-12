package com.mvp.learn.leetcode.solution.LongestPalindromeSubstring;

/**
 * 5.给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LongestPalindromeSubstring {

    /**
     * 获取给定字符串的最长回文子串。
     *
     * @param s 给定子串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length]; // dp[i][j] 表示字符串 s[i..j] 是否为回文串
        int startIndex = 0; // 回文子串起始下标
        int substrLength = 1; // 回文子串长度
        for (int j = 0; j < length; ++j) {
            for (int i = 0; i <= j; ++i) {
                boolean boolSame = s.charAt(i) == s.charAt(j);
                if (j - i < 2) {
                    // 子串长度为 1或2 时，只要 s[i] == s[j]，dp[i][j] 就为 true
                    dp[i][j] = boolSame;
                } else {
                    // 子串长度大于2时，dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]，dp[i][j] 才为 true
                    dp[i][j] = dp[i + 1][j - 1] && boolSame;
                }

                if (dp[i][j] && (substrLength < j - i + 1)) {
                    startIndex = i;
                    substrLength = j - i + 1;
                }
            }
        }

        return s.substring(startIndex, startIndex + substrLength);
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromeSubstring obj = new LongestPalindromeSubstring();
        String palindrome = obj.longestPalindrome(s);
        System.out.println("Origin String= " + s);
        System.out.println("LongestPalindromeSubstring= " + palindrome);
    }
}