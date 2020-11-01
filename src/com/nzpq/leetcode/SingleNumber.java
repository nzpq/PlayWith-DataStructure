package com.nzpq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 鹏
 * @date 2020-11-01 12:23
 *
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SingleNumber {

    private static int singleNumber(int[] nums) {

        //第一种方法
//        Map<Integer, Boolean> map = new HashMap<>();
//        for (Integer num : nums ) {
//            map.put(num,map.containsKey(num));
//        }
//        for (Integer num : nums ) {
//            if(!map.get(num)){
//                return num;
//            }
//        }
//        return 0;

        //第二种方法 异或
        /*
            任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0 = a
            任何数和其自身做异或运算，结果是 0，即 a^ a = 0
            异或运算满足交换律和结合律，即 a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a) = b ^ 0 = b。

            作者：LeetCode-Solution
            链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
            来源：力扣（LeetCode）
            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

         */
        int single = 0;
        for(Integer num : nums){
            single = single ^ num;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,7};
        System.out.println(singleNumber(nums));
    }
}
