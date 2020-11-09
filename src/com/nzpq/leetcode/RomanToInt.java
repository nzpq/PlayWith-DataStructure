package com.nzpq.leetcode;

/**
 * @author 鹏
 * @date 2020-11-09 20:25
 *
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 */
public class RomanToInt {

    /*
        按照题目的描述，可以总结如下规则：
            1、罗马数字由 I,V,X,L,C,D,M 构成；
            2、当小值在大值的左边，则减小值，如 IV=5-1=4；
            3、当小值在大值的右边，则加小值，如 VI=5+1=6；
            4、由上可知，右值永远为正，因此最后一位必然为正。

        作者：donespeak
        链接：https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static int romanToInt(String s){
        //正序遍历
//        int preNum = getValue(s.charAt(0));
//        int result = 0;
//        for (int i = 1; i < s.length(); i++) {
//            int num = getValue(s.charAt(i));
//            if(num > preNum){
//                result -= preNum;
//            }else{
//                result += preNum;
//            }
//            preNum = num;
//        }
//        result += preNum;
//        return result;

        //倒序遍历
        int result = 0;
        int lastNum = getValue(s.charAt(s.length() - 1));
        result += lastNum;
        for (int i = s.length() - 1 - 1; i >= 0; i--) {
            int num = getValue(s.charAt(i));
            if(num < lastNum){
                result -= num;
            }else{
                result += num;
            }
            lastNum = num;
        }
        return result;

    }

    private static int getValue(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XXVII"));//27
    }
}
