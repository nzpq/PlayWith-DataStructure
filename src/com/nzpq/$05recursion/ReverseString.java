package com.nzpq.$05recursion;

import java.util.Arrays;

/**
 * @author 鹏
 * @date 2020-10-23 11:01
 *
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/recursion/490ye/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'a','b','c','d'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s){
        reverseString(0,s.length - 1,s);
    }

    /**
     * 递归实现字符串反转，让start从0开始遍历，end从length-1开始遍历， 然后让char[start] char[end] 交换，当start >= end时结束
     * @param start 正序遍历
     * @param end 倒序遍历
     * @param s 字符数组
     */
    private static void reverseString(int start,int end,char[] s){
        //递归结束的条件
        if(start >= end){
            return;
        }
        //交换字符
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        reverseString(start+1,end-1,s);
    }
}
