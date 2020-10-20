package com.nzpq.leetcode;

/**
 * @author 鹏
 * @Date 2020-10-20 16:27
 *
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 *      输入：00000000000000000000000000001011
 *      输出：3
 *      解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class HammingWeight {

    public static void main(String[] args) {
        int count = hammingWeight(00000000000000000000000000001011);
        System.out.println(count); //3
    }

    /**
     * 逐位与
     * @param n 二进制数
     * @return 有多少个 ‘1’
     */
    private static int hammingWeight(int n){
        int count = 0;
        while(n != 0){
            //最后一位是1：n & 1 = 1
            //最后一位是0：n & 1 = 0
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
