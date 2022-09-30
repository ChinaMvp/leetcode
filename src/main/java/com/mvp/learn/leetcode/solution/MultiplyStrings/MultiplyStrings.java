package com.mvp.learn.leetcode.solution.MultiplyStrings;

import java.util.Arrays;

/**
 * 43、字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 *
 * 输出: "6"
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 提示：
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 */
public class MultiplyStrings {
    /**
     * 求两个整数字符串的乘积。
     *
     * @param number1 第1个数
     * @param number2 第2个数
     * @return 乘积
     */
    public String multiply(String number1, String number2) {
        int length1 = number1.length(), length2 = number2.length();
        int[] res = new int[length1 + length2];
        for (int i = 0; i < length2; ++i) {
            int digit = number2.charAt(length2 - 1 - i) - '0';
            System.out.println(String.format("before, i=%d, digit=%d, loop result=%s", i, digit, Arrays.toString(res)) );
            multiplyByDigit(number1, digit, i, res);
            System.out.println(String.format("after, i=%d, digit=%d, loop result=%s", i, digit, Arrays.toString(res)) );
        }

        System.out.println("origin result=" + Arrays.toString(res));
        StringBuilder answer = new StringBuilder();
        for (int v : res) {
            answer.append(v);
        }
        // 去除高位的0字符
        while ((answer.length() > 1) && (answer.charAt(answer.length() - 1) == '0')) {
            answer.deleteCharAt(answer.length() - 1);
        }

        return answer.reverse().toString();
    }

    /**
     *
     * @param number1 第1个数
     * @param digit2 第2个数中的数字
     * @param index2 第2个数中的数字所在的索引
     * @param result 乘积结果字符串
     */
    private void multiplyByDigit(String number1, int digit2, int index2, int[] result) {
        for (int j = number1.length() - 1, t = 0; (j >= 0) || (t > 0); --j) {
            // 计算数值1相应位置上的数字、数值2相应位置上的数字的乘积，并累加上一次计算的进位值。
            if (j >= 0) {
                int digit1 = number1.charAt(j) - '0';
                t += (digit1 * digit2);
            }
            // 计算当前位上的累加和。
            result[index2] += (t % 10);
            if (result[index2] >= 10) {
                result[index2] %= 10;
                ++result[++index2];
            } else {
                ++index2;
            }
            // 计算下一次计算的进位值。
            t /= 10;
        }
    }

    public static void main(String[] args) {
        MultiplyStrings obj = new MultiplyStrings();
        String num1 = "123", num2 = "456";
        String result = obj.multiply(num1, num2);
        System.out.println(String.format("%s * %s = %s", num1, num2, result));
    }
}
