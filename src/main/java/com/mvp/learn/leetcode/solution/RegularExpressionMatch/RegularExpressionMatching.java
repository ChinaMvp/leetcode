package com.mvp.learn.leetcode.solution.RegularExpressionMatch;

/**
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个"前面的一个元素"
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int srcLength = s.length(), patternLength = p.length();
        if (patternLength == 0) {
            return srcLength == 0;
        }

        if (p.charAt(0) == '*') {
            return false;
        }

        // dp[i][j] 表示 s[0,i) 和 p[0,j) 是否匹配，注意"前闭后开区间"。i、j表示子串的长度，而非下标。
        boolean[][] dp = new boolean[srcLength + 1][patternLength + 1];
        dp[0][0] = true;
        for (int j = 2; j < patternLength + 1; ++j) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < srcLength + 1; ++i) {
            for (int j = 1; j < patternLength + 1; ++j) {
                if ((p.charAt(j - 1) == s.charAt(i - 1)) || (p.charAt(j - 1) == '.')) {
                    // 若 p[j-1] 和 s[i-1] 匹配，则只需要判断 p[0, j-2] 和 s[0, i-2] 是否匹配。
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // 若 p[j-1] 为 *，则判断 p[j-2] 与 s[i-1] 是否匹配。
                    // 若 p[j-2] 与 s[i-1] 匹配，
                    if ((p.charAt(j - 2) == s.charAt(i - 1)) || (p.charAt(j - 2) == '.')) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        // 若 p[j-2] 与 s[i-1] 不匹配,
                        // 则使用当前src子串和去掉2个字符的pattern子串的匹配结果 作为当前子串的匹配结果。
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[srcLength][patternLength];
    }

    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        boolean result = obj.isMatch("aaaa", "a*b");
        System.out.println("result=" + result);
    }
}
