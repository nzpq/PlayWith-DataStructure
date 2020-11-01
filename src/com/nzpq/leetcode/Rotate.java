package com.nzpq.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 鹏
 * @date 2020-11-01 10:37
 *
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Rotate {

    private static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(Integer num : nums){
            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }
        }
        return false;

    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,5};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }
}
