package com.mvp.learn.leetcode.solution.RegularExpressionMatch;

/**
 * @author <a href="mailto:wangfei@yidian-inc.com">wangfei</a>
 * @since 2022/6/14 17:45:50
 */
public class RegularExpressionMatching {

    public boolean isMatch(String src, String pattern) {
        int srcLength = src.length(), patternLenth = pattern.length();
        if (patternLenth == 0) {
            return srcLength == 0;
        }

        // dp[i][j] 表示 s的前i项 和 p的前j项 是否匹配
        boolean[][] dp = new boolean[srcLength + 1][patternLenth + 1];
        dp[0][0] = true;
        for (int j = 1; j < patternLenth + 1; ++j) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < srcLength + 1; ++i) {
            for (int j = 1; j < patternLenth + 1; ++j) {
                if (src.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    if (src.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[srcLength][patternLenth];
    }

    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        boolean result = obj.isMatch("abc", "abc*");
        System.out.println("result=" + result );
    }
}
