package com.nzpq.leetcode;

/**
 * @author 鹏
 * @date 2020-10-31 10:53
 *
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 输入: 121
 * 输出: true
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class IsPalindrome {

    private boolean isPalindrome(int x){
        //x<0直接返回false
        if(x < 0) return false;

        int reverse = 0;//反转后的结果
        int num = x; //
        while(num != 0){
            reverse = reverse * 10+ num % 10;
            num = num / 10;
        }

        return x == reverse;
    }
}
