package com.mvp.learn.leetcode.solution.MultiplyStrings;

import java.util.Arrays;

/**
 * 43、字符串相乘
 */
public class MultiplyStrings {
    public String multiply(String number1, String number2) {
        int length1 = number1.length(), length2 = number2.length();
        int[] res = new int[length1 + length2];
        for (int i = 0; i < length2; ++i) {
            int digit = number2.charAt(length2 - 1 - i) - '0';
            System.out.println(String.format("before, i=%d, digit=%d, loop result=%s", i, digit, Arrays.toString(res)) );
            mul(number1, digit, i, res);
            System.out.println(String.format("after, i=%d, digit=%d, loop result=%s", i, digit, Arrays.toString(res)) );
        }

        System.out.println("origin result=" + Arrays.toString(res));
        StringBuilder answer = new StringBuilder();
        for (int v : res) {
            answer.append(v);
        }
        while ((answer.length() > 1) && (answer.charAt(answer.length() - 1) == '0')) {
            answer.deleteCharAt(answer.length() - 1);
        }

        return answer.reverse().toString();
    }

    private void mul(String number1, int digit, int index, int[] result) {
        for (int j = number1.length() - 1, t = 0; (j >= 0) || (t > 0); --j) {
            if (j >= 0) {
                int a = number1.charAt(j) - '0';
                t += a * digit;
            }
            result[index] += t % 10;
            if (result[index] >= 10) {
                result[index] %= 10;
                ++result[++index];
            } else {
                ++index;
            }
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
