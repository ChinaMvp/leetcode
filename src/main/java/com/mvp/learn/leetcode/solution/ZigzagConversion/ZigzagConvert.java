package com.mvp.learn.leetcode.solution.ZigzagConversion;

/**
 * 6.将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class ZigzagConvert {
    public String convert(String src, int numRows) {
        if (numRows == 1) {
            return src;
        }

        StringBuilder answer = new StringBuilder();
        int maxInterval = 2 * numRows - 2; // 两个字符间最大间隔值
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            int interval;
            if (rowIndex == (numRows - 1)) {
                // 对于最后一行，同一行两个字符间隔为最大间隔值
                interval = maxInterval;
            } else {
                // 对于非最后一行，同一行两个字符的初次间隔为：最大间隔值 减去 2乘以行索引值
                interval = maxInterval - 2 * rowIndex;
            }

            // 逐行读取
            int index = rowIndex;
            while (index < src.length()) {
//                System.out.print(src.charAt(index));
//                for (int i = 0; i < interval; i++) {
//                    System.out.print(' ');
//                }
                answer.append(src.charAt(index));
                index += interval;
                interval = maxInterval - interval;
                if (interval == 0) {
                    interval = maxInterval;
                }
            }
            System.out.println();
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        ZigzagConvert obj = new ZigzagConvert();
        String src = "PAYPALISHIRINGWA";
        int numRows = 4;
        String convertResult = obj.convert(src, numRows);
        System.out.println("originString = " + src);
        System.out.println("convertResult= " + convertResult);
    }
}