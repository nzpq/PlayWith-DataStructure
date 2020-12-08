package com.nzpq.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author NiuZhiPeng
 * @date 2020/12/08 18:11
 * @Description：771. 宝石与石头
 *
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class NumJewelsInStones {

    public static int numJewelsInStones(String J,String S){

        Set<Character> set = new HashSet<>();
        for(int i = 0; i < J.length(); i++){
            set.add(J.charAt(i));
        }
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(set.contains(S.charAt(i))){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String j = "z";
        String s = "ZZ";
        System.out.println(numJewelsInStones(j,s));
        Set<Character> set = new HashSet<>();
        set.add('z');
        System.out.println(set.contains('Z'));

    }
}
