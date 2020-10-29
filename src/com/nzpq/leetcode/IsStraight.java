package com.nzpq.leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 鹏
 * @date 2020-10-29 9:33
 *
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class IsStraight {

    /**
     * set + 排序实现
     * 假设这组扑克牌的最大最小值为max min
     * 满足是顺子的两个条件
     *  1、这组扑克牌不重复
     *  2、max - min < 5
     *
     * @param nums 扑克牌
     * @return 是否是顺子
     */
    private static boolean isStraight(int[] nums){

        //创建set，判断数组中是否有元素重复
        Set<Integer> set = new HashSet<>();

        //遍历数组
        int max = 0;
        int min = 14;
        for(int num : nums) {
            //不用管大小王
            if(num == 0){
                continue;
            }
            max = Math.max(max,num);
            min = Math.min(min,num);

            //判断是否重复
            if(set.contains(num)){
                return false;
            }else{
                set.add(num);
            }

        }
        return max - min < 5;
    }

    /**
     * 第二种方法，排序+遍历
     * 用flag统计大小王的数量，nums[i] == nums[i+1] 判断是否有重复的，最后判断[nums.length - 1] - nums[flag] < 5
     * @param nums
     * @return
     */
    private static boolean isStraight2(int[] nums){

        Arrays.sort(nums);
        int flag = 0;
        //i < nums.length - 1 防止出现数组越界
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                flag++;
            }else if(nums[i] == nums[i+1]){
                return false;
            }
        }
        return nums[nums.length - 1] - nums[flag] < 5;

    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        System.out.println(isStraight2(nums));
    }
}
