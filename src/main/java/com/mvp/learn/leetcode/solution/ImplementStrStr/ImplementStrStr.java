package com.mvp.learn.leetcode.solution.ImplementStrStr;

/**
 * 28.实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * 示例 ：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        int len1 = haystack.length();
        int len2 = needle.length();
        int p = 0;
        int q = 0;
        while (p < len1) {
            if (haystack.charAt(p) == needle.charAt(q)) {
//                if (len2 == 1) {
//                    return p;
//                }
                ++p;
                ++q;
            } else {
                p = p - q + 1;
                q = 0;
            }

            if (q == len2) {
                return p - q;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr obj = new ImplementStrStr();
        String haystack = "hehllo";
        String needle = "hll";
        int index = obj.strStr(haystack, needle);
        System.out.println("java string indexOf = " + haystack.indexOf(needle));
        System.out.println("index=" + index);
    }
}