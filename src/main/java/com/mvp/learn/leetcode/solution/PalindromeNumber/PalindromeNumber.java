package com.mvp.learn.leetcode.solution.PalindromeNumber;


/**
 * 9.给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 */
public class PalindromeNumber {
    /**
     * 判定整数是否为回文
     *
     * @param x 给定整数
     * @return
     */
    public boolean isIntPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int y = 0, t = x;
        int remainder;
        while (t != 0) {
            remainder = t % 10;;
            t /= 10;
            y = y * 10 + remainder;
        }

        return x == y;
    }

    /**
     * 判定字符串是否为回文
     *
     * @param x 给定字符串
     * @return
     */
    public boolean isStringPalindrome(String x) {
        if ((null == x) || (x.length() == 0)) {
            return false;
        }

        int length = x.length();
        int halfLength = length / 2;
        int i, j;
        if (length % 2 == 0) {
            // 长度为偶数
            i = halfLength - 1;
            j = halfLength;
        } else {
            // 长度为奇数
            i = j = halfLength;
        }

        for (; (i >= 0) && (j < length); i--, j++) {
            if (x.charAt(i) != x.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber obj = new PalindromeNumber();
        String s = "1221";
        boolean isPalindrome = obj.isStringPalindrome(s);
        System.out.println("origin string=" + s);
        System.out.println("isPalindrome=" + isPalindrome);

        int x = 156651;
        isPalindrome = obj.isIntPalindrome(x);
        System.out.println("origin number=" + x);
        System.out.println("isPalindrome=" + isPalindrome);
    }
}
