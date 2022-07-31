package com.mvp.learn.leetcode.solution.SubstringWithConcatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 30、串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words 。找出 s 中31恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * 示例 ：
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 */
public class SubstringWithConcatenation {

    /**
     * 获取src中恰好可以由 words 中所有单词串联形成的子串的起始位置
     *
     * @param src 原始字符串
     * @param words words数组
     * @return src中恰好可以由 words 中所有单词串联形成的子串的起始位置
     */
    public List<Integer> findSubstring(String src, String[] words) {
        // key 为 word，value 为 word 出现的个数
        Map<String, Integer> word2CountMap = new HashMap<>();
        for (String word : words) {
            word2CountMap.put(word, word2CountMap.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length(); // words中子串的长度都相同
        int srcLength = src.length(), wordNumber = words.length;
        List<Integer> result = new ArrayList<>();
        // 逐位遍历，保证所有情况都遍历到。
        for (int i = 0; i < wordLength; ++i) {
            // key为word，value为word出现的个数
            Map<String, Integer> word2CountMapTemp = new HashMap<>();
            int slowIndex = i, fastIndex = i;
            int wordNumberTemp = 0;
            while (fastIndex + wordLength <= srcLength) {
                String word = src.substring(fastIndex, fastIndex + wordLength);
                fastIndex += wordLength;
                // 如果words中不包含word，则直接进行下一轮循环，跳过判定逻辑
                if (!word2CountMap.containsKey(word)) {
                    slowIndex = fastIndex;
                    word2CountMapTemp.clear();
                    wordNumberTemp = 0;
                    continue;
                }

                word2CountMapTemp.put(word, word2CountMapTemp.getOrDefault(word, 0) + 1);
                ++wordNumberTemp;
                while (word2CountMapTemp.get(word) > word2CountMap.get(word)) {
                    String removeWord = src.substring(slowIndex, slowIndex + wordLength);
                    slowIndex += wordLength;
                    word2CountMapTemp.put(removeWord, word2CountMapTemp.get(removeWord) - 1);
                    --wordNumberTemp;
                }

                if (wordNumber == wordNumberTemp) {
                    result.add(slowIndex);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenation obj = new SubstringWithConcatenation();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> subIndexList = obj.findSubstring(s, words);
        System.out.println("result=" + subIndexList.toString());
    }
}