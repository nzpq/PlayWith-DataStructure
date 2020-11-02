package com.nzpq.leetcode;

import java.util.Arrays;

/**
 * @author 鹏
 * @date 2020-11-02 10:15
 *
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {

    /*
        定义变量j,j用来记录非0的个数
        遍历数组，只要遇到0，就让0后边的那个元素左移
        遍历完后，j指向的索引就是最后一个不为0元素的下一个位置，然后让j后边的元素都设为0
     */
    private static void moveZeroes(int[] nums){

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        //让j后边的元素都为0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
