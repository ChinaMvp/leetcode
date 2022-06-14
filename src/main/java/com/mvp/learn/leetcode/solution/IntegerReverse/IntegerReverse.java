package com.mvp.learn.leetcode.solution.IntegerReverse;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例：
 * 输入：x = -1230
 * 输出：-321
 */
public class IntegerReverse {
    public int reverse(int x) {
        long result = 0;
        long remainder = 0;
        // 考虑负数情况，所以这里条件为: x != 0
        while (x != 0) {
            remainder = x % 10;
            x /= 10;
            result = result * 10 + remainder;
        }
        return result < Integer.MIN_VALUE || result > Integer.MAX_VALUE ? 0 : (int) result;
    }

    public static void main(String[] args) {
        int value = -1230;
        IntegerReverse obj = new IntegerReverse();
        int result = obj.reverse(value);
        System.out.println("origin=" + value + ", result=" + result);

        value = 369;
        result = obj.reverse(value);
        System.out.println("origin=" + value + ", result=" + result);
    }
}