package com.nzpq.leetcode;

/**
 * @author NiuZhiPeng
 * @date 2020/12/17 18:11
 * @Description： 1281. 整数的各位积和之差
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * 示例 1：
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 链接：https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class SubtractProductAndSum {

    public static int subtractProductAndSum(int n) {
        int multiply = 1;
        int sum = 0;
        while(n != 0){
           multiply *= n % 10;
           sum += n % 10;
           n /= 10;
        }

        return multiply - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(4421));
    }
}
