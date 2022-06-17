package com.mvp.learn.leetcode.solution.RegularExpressionMatch;

/**
 * 10. 正则表达式匹配
 *
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
                    // 若 p[j-1] 和 s[i-1] 匹配,，则只需要判断 p[0, j-2] 和 s[0, i-2] 是否匹配。
                    dp[i][j] = dp[i - 1][j - 1];
                    System.out.println("p[" + (j-1) + "]=" + p.charAt(j - 1) +
                            "和 s[" + (i-1) + "]=" + s.charAt(i - 1) + " 匹配, i=" + i + ", j=" + j + ", " + dp[i][j]);
                } else if (p.charAt(j - 1) == '*') {
                    // 若 p[j-1] 为 *，则判断 p[j-2] 与 s[i-1] 是否匹配。
                    // 若 p[j-2] 与 s[i-1] 匹配，有以下两种情况：
                    // 第一种情况：匹配0次。譬如 s=abcd，p=abc*d，p=abc与s=abc匹配，在p=abc*与s=abc匹配时，*匹配0次字符c，
                    // 则 p子串 应忽略 c* 两个字符。"p[0, j-1] 匹配 s[0, i-1]的结果" 与 "p[0, j-3] 匹配 s[0, i-1]" 的结果一致。
                    // 即 dp[i][j] = dp[i][j - 2]。
                    // 第二种情况：匹配1或多次。譬如 a=abbb，p=ab*，p=ab与s=ab匹配，在p=abb与s=ab*匹配时，*匹配1次字符b，
                    // 则 "p[0, j-1] 匹配 s[0, i-1]的结果" 与 "p[0, j-1] 匹配 s[0, i-2]" 的结果一致。
                    // 即 dp[i][j] = dp[i - 1][j];
                    if ((p.charAt(j - 2) == s.charAt(i - 1)) || (p.charAt(j - 2) == '.')) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                        System.out.println("p[" + (j-1) + "]=" + p.charAt(j - 1) + ", p[" + (j-2) + "]=" + p.charAt(j - 2)
                                + "和 s[" + (i-1) + "]=" + s.charAt(i - 1) + " 匹配, i=" + i + ", j=" + j + ", " + dp[i][j]);
                    } else {
                        // 若 p[j-2] 与 s[i-1] 不匹配，则 p子串匹配s子串时 应忽略 p[j-2]、p[j-1] 两个字符。
                        // "p[0, j-1] 匹配 s[0, i-1]的结果" 与 "p[0, j-3] 匹配 s[0, i-1] 的结果" 一致。
                        // 譬如 s=abcde，p=abc*de，*前的字符c与d不匹配，则 p子串匹配s子串时 应忽略 *c 两个字符，
                        // "p=abc* 与 s=abcd 的匹配结果" 和 "p=ab 与 s=abcd 的匹配结果"一致。
                        dp[i][j] = dp[i][j - 2];
                        System.out.println("p[" + (j-1) + "]=" + p.charAt(j - 1) + ", p[" + (j-2) + "]=" + p.charAt(j - 2)  +
                                "和 s[" + (i-1) + "]=" + s.charAt(i - 1) + " 不匹配, 去除" + p.charAt(j - 2) +
                                p.charAt(j - 1)  + ", i=" + i + ", j=" + j + ", " + dp[i][j]);
                    }
                } else {
                    dp[i][j] = false;
                    System.out.println("other, p[" + (j-1) + "]=" + p.charAt(j - 1) +
                            "和 s[" + (i-1) +  "]=" + s.charAt(i - 1) + " 不匹配, i=" + i + ", j=" + j + ", " + dp[i][j]);
                }
            }
        }

        return dp[srcLength][patternLength];
    }

    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        boolean result = obj.isMatch("abbb", "ab*");
        System.out.println("result=" + result);
    }
}
