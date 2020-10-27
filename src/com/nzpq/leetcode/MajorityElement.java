package com.nzpq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 鹏
 * @date 2020-10-27 9:11
 *
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = {6,5,5};

        int res = majorityElement(nums);
        System.out.println(res);
    }


    private static int majorityElement(int[] nums){

        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.getOrDefault(num, 0) + 1);
            }else{
                map.put(num,1);
            }
            if(map.get(num) > nums.length / 2){
                return num;
            }
        }
        return 0;
    }
}
