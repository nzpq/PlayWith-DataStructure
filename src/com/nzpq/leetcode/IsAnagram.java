package com.nzpq.leetcode;

/**
 * @author 鹏
 * @date 2020-11-05 10:12
 *
 * 有效的字母异位词
 * 字母异位词是指由相同的字母按照不同的顺序组成的单词，
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsAnagram {

    private static boolean isAnagram(String s, String t) {

        //先判断二者的长度
        if(s.length() != t.length()){
            return false;
        }
        //初始化一个数组，用于计数，
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 'a' = 97
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for(int n : counter){
            if(n != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat","tar"));
    }


}
