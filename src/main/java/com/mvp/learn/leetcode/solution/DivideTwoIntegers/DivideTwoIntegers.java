package com.mvp.learn.leetcode.solution.DivideTwoIntegers;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

 * 示例:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 */
public class DivideTwoIntegers {
    public int divide(int a, int b) {
        int sign = 1;
        // 判断符号
        if ((a < 0) != (b < 0)) {
            sign = -1;
        }

        long x = Math.abs((long) a);
        long y = Math.abs((long) b);
        long total = 0;
        int cnt;
        while (x >= y) {
            cnt = 0;
            while (x >= (y << (cnt + 1))) {
                cnt++;
            }
            x -= (y << cnt);
            total += (1L << cnt);
        }

        long result = sign * total;
        if ((result >= Integer.MIN_VALUE) && (result <= Integer.MAX_VALUE)) {
            return (int) result;
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        DivideTwoIntegers obj = new DivideTwoIntegers();
        int a = 10;
        int b = 3;
        int result = obj.divide(a, b);
        System.out.println("a=" + a + ", b=" + b + ", " + "result=" + result);
    }
}
