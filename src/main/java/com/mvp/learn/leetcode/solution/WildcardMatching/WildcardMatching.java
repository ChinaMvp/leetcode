package com.mvp.learn.leetcode.solution.WildcardMatching;

/**
 * 44、通配符匹配
 * 给定一个字符串 (s) 和 一个字符模式 (p)，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 *
 * 示例 3:
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 * 示例 4:
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce"。
 *
 * 示例 5:
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 *
 * DP思路：
 * 　　1. dp找状态转移方程，对于 s中前i个字符与p中前j个字符：
 * 　　　　1）p[j] == s[i] && dp[i-1][j-1]   =>  dp[i][j] = True
 * 　　　　2) p[j]  == '?'  && dp[i-1][j-1]  =>  dp[i][j] = True
 * 　　　　3) p[j] == '*'
 * 　　　　　　(1) 选择不使用*，则dp[i][j] = dp[i][j-1]，譬如：s=abde, p=ab*de。
 * 　　　　　　(2) 选择使用*，则dp[i][j]  = dp[i-1][j]，譬如：s=abcde, p=ab*de。
 * 　　　　　 （3）综合起来  dp[i][j] = dp[i][j-1] or dp[i-1][j]
 * 　　　　4) 对于 ‘3)’中的情况，其实很难理解，这里需要过一下s,j的双重循环，理解怎么在遍历
 * 　　　　　　（1） 首先对于s[0]遍历p中每一个字符，看能否匹配，如果s[0]是‘*’，则能完全匹配p，则dp[0][0-j-1]都是True
 * 　　　　　　（2） 再看s[1]，看能匹配到哪里，然后s[2].....
 * 　　　　　　（3） 所以 3.1中不使用‘*’的意思是，看s[i]在j=0~j=len(p)-1的过程中，能不能匹配s[i][j-1]
 * 　　　　　　（4） 3.2中使用的意思是，对于上一个s字符s[i-1]是否已经匹配过p[j]
 * 　　　　　　（5） 综上，弄清楚dp的遍历顺序对于理解  p[j] == '*'  的情况很重要。
 * 　　2. dp初始化
 * 　　　　1）本题是顺序遍历，需要用到 dp[i-1][j-1] dp[i-1][j] dp[i][j-1]，所以初始化时需要在前面预留一行一列。
 * 　　　　2）dp[0][0] = True 。
 * 　　　　3)  对于dp[0][j]，如果p一直是‘*’，则可一直匹配空串。
 */
public class WildcardMatching {
    /**
     * 判断指定字符串是否符合指定模式。
     *
     * @param src 字符串
     * @param pattern 模式
     * @return 是否匹配
     */
    public boolean isMatch(String src, String pattern) {
        // dp[i][j]是指："pattern的前i1个字符"是否匹配"src的前j个字符"。
        boolean[][] dp = new boolean[pattern.length() + 1][src.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= src.length(); i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= pattern.length(); i++) {
            if (pattern.charAt(i - 1) == '*') {
                // *代表 n个字符 或 0个字符
                dp[i][0] = dp[i - 1][0];
                for (int j = 1; j <= src.length(); j++) {
                    // (1) 若选择不使用*，则 dp[i][j] = dp[i][j-1]
                    // (2) 若选择使用*，则 dp[i][j] = dp[i-1][j]
                    dp[i][j] = (dp[i][j - 1] || dp[i - 1][j]);
                }
            } else if (pattern.charAt(i - 1) == '?') {
                dp[i][0] = false;
                for (int j = 1; j <= src.length(); j++) {
                    // ？只能代表上一个字符
                    dp[i][j] = dp[i - 1][j - 1];
                }
            } else {
                dp[i][0] = false;
                for (int j = 1; j <= src.length(); j++) {
                    //其他时刻  必须是完全相等的时候才可以
                    dp[i][j] = (src.charAt(j - 1) == pattern.charAt(i - 1)) && dp[i - 1][j - 1];
                }
            }
        }

        return dp[pattern.length()][src.length()];
    }

    public static void main(String[] args) {
        WildcardMatching obj = new WildcardMatching();
        String s = "adceb";
        String p = "ad*cb";
        boolean result = obj.isMatch(s, p);
        System.out.println("result=" + result);
    }
}
