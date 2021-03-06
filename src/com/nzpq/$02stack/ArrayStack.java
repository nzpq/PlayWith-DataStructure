package com.nzpq.$02stack;

import com.nzpq.$01array.Array;

/**
 * @author 鹏
 * @Date 2020-10-14 21:39
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack (){
        array = new Array<>();
    }

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("stack：[");
        for(int i = 0; i < array.getSize(); i++){
            sb.append(array.get(i));
            if(i != array.getSize() - 1){
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
