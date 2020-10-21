package com.nzpq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 鹏
 * @Date 2020-10-21 23:24
 *
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *      s = "abaccdeff"
 *      返回 "b"
 *      s = ""
 *      返回 " "
 *  https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqChar {

    private static char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.put(ch,map.containsKey(ch));
        }
        for (char c : chars) {
            if (!map.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {

        char ch = firstUniqChar("abfcde");
        System.out.println(ch);
    }
}
