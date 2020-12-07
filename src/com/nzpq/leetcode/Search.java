package com.nzpq.leetcode;

/**
 * @author 鹏
 * @date 2020-10-30 10:01
 *
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。没找到则输出0
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class Search {

    /**
     * 统计target在数组nums中出现的次数
     *      二分法，定义left和right，让他们指向target的左右边界，最后返回nums[right] - nums[left] - 1
     * @param nums 数组
     * @param target 目标元素
     * @return target出现的次数
     */
    private static int search(int[] nums,int target){
        //查找右边界
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            int m = (i + j) / 2;
            if(nums[m] <= target){
                i = m + 1;
            }else{
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target){
            return 0;
        }
        //找左节点
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) {
                i = m + 1;
            }
            else {
                j = m - 1;
            }
        }
        int left = j;

        return right - left - 1;
    }
}
