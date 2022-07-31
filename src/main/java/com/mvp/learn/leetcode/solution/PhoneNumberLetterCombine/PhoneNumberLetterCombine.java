package com.mvp.learn.leetcode.solution.PhoneNumberLetterCombine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 17、电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 2 => abc, 3 => def, 4 => ghi,
 * 5 => jkl, 6 => mno, 7 => pqrs,
 * 8 => tuv, 9 => wxyz
 *
 * 注意：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class PhoneNumberLetterCombine {
    public List<String> letterCombinations(String digits) {
        if ((digits == null) || (digits.length() == 0)) {
            return Collections.emptyList();
        }

        List<String> chars = Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

        List<String> strs = new ArrayList<>();
        for (char charDigit : digits.toCharArray()) {
            // charDigit 为[2,9] 之间的字符
            strs.add(chars.get(charDigit - '0' - 2));
        }

        List<String> result = new ArrayList<>();
        for (String str : strs) {
            if (result.size() == 0) {
                for (char c : str.toCharArray()) {
                    result.add(String.valueOf(c));
                }
            } else {
                List<String> cache = new ArrayList<>();
                for (String item : result) {
                    for (char c : str.toCharArray()) {
                        cache.add(item + c);
                    }
                }
                result = cache;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PhoneNumberLetterCombine obj = new PhoneNumberLetterCombine();
        String digits = "23";
        List<String> result = obj.letterCombinations(digits);
        System.out.println("digits=" + result.toString());
    }
}
