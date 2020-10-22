package com.nzpq.$06tree;

import java.util.ArrayList;
import java.util.Random;

/**
 * 测试二分搜索树
 * @author 鹏
 * @Date 2020-10-21 10:48
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
         /*
            int[] nums = {5,3,6,8,4,2};
            BinarySearchTree<Integer> tree = new BinarySearchTree<>();
            for (int i : nums){
                tree.add(i);
            }
            /////////////////
            //      5      //
            //    /   \    //
            //   3    6    //
            //  / \    \   //
            // 2  4     8  //
            /////////////////


            System.out.println("前序遍历");
            tree.prevOrder(); //5.3.2.4.6.8

            System.out.println("非递归前序遍历");
            tree.inorderNotRecursion(); //5.3.2.4.6.8

            System.out.println("中序遍历");
            tree.inOrder(); //2,3,4,5,6,8

            System.out.println("后序遍历");
            tree.postOrder(); //2,4，3，8，6，5

            System.out.println("层序遍历");
            tree.levelOrder(); //5 3 6 2 4 8

            System.out.println("***************");
            System.out.println(tree);

         */

         //测试删除最小元素
         BinarySearchTree<Integer> tree = new BinarySearchTree<>();
         Random random = new Random();
        for (int i = 0; i < 100; i++) {
            tree.add(random.nextInt(100));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!tree.isEmpty()){
            list.add(tree.removeMin());
        }
        System.out.println(list);

        //测试删除最大元素
        for (int i = 0; i < 100; i++) {
            tree.add(random.nextInt(100));
        }
        list = new ArrayList<>();
        while(!tree.isEmpty()){
            list.add(tree.removeMax());
        }
        System.out.println(list);
    }
}
