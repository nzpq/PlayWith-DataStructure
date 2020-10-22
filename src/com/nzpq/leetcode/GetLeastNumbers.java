package com.nzpq.leetcode;

/**
 * @author 鹏
 * @Date 2020-10-22 10:57
 *
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *      输入：arr = [3,2,1], k = 2
 *      输出：[1,2] 或者 [2,1]
 *
 *  https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {


    /**
     * 
     * @param arr 整数数组 arr
     * @param k 最小的k个数
     * @return 数组
     */
    private static int[] getLeastNumbers(int[] arr, int k) {
        
        //先对原始数组排序，冒泡排序
        //比较两个相邻的元素，将值大的元素交换到右边
        //外层循环控制比较的轮数：length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环控制每轮比较的次数，
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //判断是否需要交换
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        //遍历排序后的数组，输出k个数即可
        int[] result = new int[k];
        /*
            参数含义：arr 原始数组， srcPos 从元数据的起始位置开始
                    dest 目标数组 destPos 目标数组的开始起始位置
                    length  : 要copy的数组的长度

         */
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }
}
