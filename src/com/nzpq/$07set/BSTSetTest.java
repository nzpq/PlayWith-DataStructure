package com.nzpq.$07set;

import java.util.ArrayList;

/**
 * @author 鹏
 * @date 2020-10-26 10:36
 */
public class BSTSetTest {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words);
        System.out.println("单词个数："+words.size()); //125901

        BinarySearchTree<String> tree = new BinarySearchTree<>();
        for(String word : words) {
            tree.add(word);
        }
        System.out.println("词汇量： "+tree.getSize()); //6530
    }
}
