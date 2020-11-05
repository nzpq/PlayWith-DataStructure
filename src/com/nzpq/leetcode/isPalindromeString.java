package com.nzpq.leetcode;

/**
 * @author 鹏
 * @date 2020-11-05 10:45
 *
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class isPalindromeString {


    private static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            //移动左指针
            /*
                这里判断left < right是防止字符串中都是空格
                Character.isLetterOrDigit(char c) 当字符c为字母或者数字时返回true，否则返回false
             */
            //从左往右移动左指针，跳过空格和特殊字符
           while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
           }
            //从右往左移动右指针，跳过空格和特殊字符
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            //判断left和right指向的元素是否相等
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
