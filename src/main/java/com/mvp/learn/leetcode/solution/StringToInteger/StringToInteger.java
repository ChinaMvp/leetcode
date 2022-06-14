package com.mvp.learn.leetcode.solution.StringToInteger;

/**
 * 8.实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2的31次方,  2的31次方 − 1] ，需要截断这个整数，使其保持在这个范围内。
 * 具体来说，小于 −2的31次方 的整数应该被固定为 −2的31次方 ，大于 2的31次方 − 1 的整数应该被固定为 2的31次方 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略任何其他字符。
 */
public class StringToInteger {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }

        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int i = 0;
        while (s.charAt(i) == ' ') {
            // 仅包含空格
            if (++i == n) {
                return 0;
            }
        }

        // 计算数值符号（正负数），默认为正数
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            ++i;
        }

        // 2的31次方为2147483648，32位正数的最大值为2147483648-1=2147483647，32位负数的最大值为-2147483648
        int result = 0;
        int thresholdValue = Integer.MAX_VALUE / 10;
        int lastDigitValue = '7';
        for (; i < n; ++i) {
            // 非数字，跳出循环体
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            // 溢出判断
            if ((result > thresholdValue) || ((result == thresholdValue) && (s.charAt(i) > lastDigitValue))) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + (s.charAt(i) - '0');
        }

        return sign * result;
    }

    public static void main(String[] args) {
        String src = "     -3021";
        StringToInteger obj = new StringToInteger();
        int result = obj.myAtoi(src);
        System.out.println("src=" + src + ", result=" + result);
        System.out.println("src.charAt(length-1)=" + src.charAt(src.length() - 1));
    }
}
