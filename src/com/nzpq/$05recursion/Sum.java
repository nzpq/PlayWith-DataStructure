package com.nzpq.$05recursion;

/**
 * 对数组元素进行求和——递归
 * @author 鹏
 * @Date 2020-10-19 14:15
 */
public class Sum {

    //用户调用求和的方法，只用让用户调用即可，无需让用户知道底层实现
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    /**
     * 递归求和
     * @param arr 被求和的数组
     * @param l 相当于遍历数组的索引
     * @return 结果
     */
    private static int sum(int[] arr,int l){
        //结束的条件，数组为0或者遍历完毕
        if(l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr,l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        System.out.println(sum(arr));
    }
}
