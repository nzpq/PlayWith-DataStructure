package com.nzpq.leetcode;

/**
 * @author NiuZhiPeng
 * @date 2020/12/17 18:31
 * @Description： 1684. 统计一致字符串的数目
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * 请你返回 words 数组中 一致字符串 的数目。
 * 示例 1：
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings/
 */
public class CountConsistentStrings {

    public static int countConsistentStrings(String allowed, String[] words) {

        int count = 0;
        for (String s : words){
            char[] chars = s.toCharArray();
            //遍历chars，统计chars中有几个字符在allowed中
            int num = 0;
            for (char ch : chars){
                if (allowed.indexOf(ch) != -1){
                    num++;
                }
            }
            //单个字符串遍历完毕，判断字符串的长度和num，也就是判断是否每个字符都出现在allowed
            if(num == chars.length){
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        String allowed = "abc";
        String[] words = {"a","b","c","ab","ac","bc","abc"};
        System.out.println(countConsistentStrings(allowed,words));
    }
}
