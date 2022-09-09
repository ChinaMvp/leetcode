package com.mvp.learn.leetcode.solution.CountAndSayDigits;

/**
 * 38、外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 * 要描述一个数字字符串，首先要将字符串分割为最小数量的组，每个组都由连续的、最多相同的字符组成。
 * 然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。
 *
 */
public class CountAndSayDigits {

    /**
     * 计算外观序列
     *
     * @param n 第n次描述
     * @return 外观序列结果
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        int i = 1;
        String str = "1";
        System.out.println("i=" + i + ", str=" + str);

        // 基准字符
        char base;
        // 基准字符个数
        int count;
        for (i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            // 初始化基准字符及其个数
            base = str.charAt(0);
            count = 1;
            for (int j = 1; j < str.length(); j++) {
                char curr = str.charAt(j);
                if (base == curr) {
                    count++;
                } else {
                    // 添加基准字符及其个数到结果字符串中
                    builder.append(count).append(base);
                    // 重置基准字符及其个数
                    base = curr;
                    count = 1;
                }
            }

            // 添加最后一个基准字符及其个数到结果字符串中
            builder.append(count).append(base);
            str = builder.toString();
            System.out.println("i=" + i + ", str=" + str);
        }

        return str;
    }

    public static void main(String[] args) {
        CountAndSayDigits obj = new CountAndSayDigits();
        // 描述序号（第几次描述）
        int n = 5;
        String result = obj.countAndSay(n);
        System.out.println("n=" + n + ", result=" + result);
    }
}