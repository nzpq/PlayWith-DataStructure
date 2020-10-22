package com.nzpq.leetcode;

/**
 * @author 鹏
 * @date 2020-10-22 21:28
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWords {

    private static String reverse(String s){

        //去除首尾空格
        s = s.trim();
        //倒序遍历
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = i;
        while(i >= 0){
            //找第一个空格
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            //拼接单词
            sb.append(s, i+1, j+1).append(" ");
            //跳过单词间的空格
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }


    public static void main(String[] args) {

//        String s = "01234567";
//        System.out.println(s.charAt(7));
//        s = s.substring(7,8);
//        System.out.println(s);

        System.out.println(reverse( "  hello world!  "));

    }

}
