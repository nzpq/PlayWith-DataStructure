package com.nzpq.leetcode;

/**
 * @author 鹏
 * @Date 2020-10-19 23:10
 *
 * 867. 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *  矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 *      输入：[[1,2,3],[4,5,6],[7,8,9]]
 *      输出：[[1,4,7],[2,5,8],[3,6,9]]
 *示例 2：
 *      输入：[[1,2,3],[4,5,6]]
 *      输出：[[1,4],[2,5],[3,6]]
 * https://leetcode-cn.com/problems/transpose-matrix/
 */
public class TransposeMatrix {

    public static void main(String[] args) {

        int[][] test = new int[][]{{1,2,3},{4,5,6}};

        int[][] result = transpose(test);
        for (int[] ints : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }


    private static int[][] transpose(int[][] A){

        int row = A.length; //原数组的行当作转置后的列
        int column = A[0].length; //原数组的列当作转置后的行

        int[][] result = new int[column][row];

        //遍历原始二维数组
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
