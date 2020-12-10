package com.nzpq.$07set;

/**
 * 使用二分搜索树实现Set
 * @author 鹏
 * @date 2020-10-26 10:11
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> tree;

    public BSTSet() {
        tree = new BinarySearchTree<>();
    }


    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return tree.contains(e);
    }

    @Override
    public void add(E e) {
        tree.add(e);
    }

    @Override
    public void remove(E e) {
        tree.remove(e);
    }

    @Override
    public int getSize() {
        return tree.getSize();
    }
}
