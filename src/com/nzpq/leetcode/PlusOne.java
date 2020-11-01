package com.nzpq.leetcode;

/**
 * @author 鹏
 * @date 2020-11-01 20:36
 *
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PlusOne {

    private static int[] plusOne(int[] digits){

        for(int i = digits.length - 1; i >= 0; i--){
            digits[i]++;
            digits[i] %= 10;//对十取模，如果是0，则需要进位，进入下一次循环，不为0直接返回
            if(digits[i] != 0){
                return digits;
            }
        }
        //如果对数组遍历完毕后，仍没有返回，则说明最高位也需要进位，比如99+1这种情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
