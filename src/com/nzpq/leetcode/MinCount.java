package com.nzpq.leetcode;

/**
 * @author NiuZhiPeng
 * @date 2020/12/11 17:44
 * @Description： LCP 06. 拿硬币
 *
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * 示例 1：
 * 输入：[4,2,1]
 * 输出：4
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 */
public class MinCount {

    /**
     * 只需要判断每一堆的力扣币数是否是偶数
     * 如果是偶数则至少要拿coins[i]/2次
     * 如果是奇数则至少要拿coins[i]/2 + 1次
     * @param coins
     * @return
     */
    public static int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            if (coin % 2 == 0)
                count += coin / 2;
            else
                count += coin / 2 + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] coins = {4,2,1};
        System.out.println(minCount(coins));
    }

}
