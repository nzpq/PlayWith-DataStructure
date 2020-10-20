package com.nzpq.$04linkledist;

import com.nzpq.$02stack.Stack;

/**
 * 使用链表实现栈
 * @author 鹏
 * @Date 2020-10-17 13:22
 */
public class LinkedListStack<E> implements Stack<E> {

    //自定义的链表
    private LinkedList<E> linkedList;

    public LinkedListStack (){
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("linkedListStack top ");
        sb.append(linkedList);
        return sb.toString();
    }
}
