package com.nzpq.$03queue;

import com.nzpq.$01array.Array;

/**
 * @author 鹏
 * @Date 2020-10-15 10:13
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue (){
        array = new Array<>();
    }

    public ArrayQueue (int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("queue front [");
        for(int i = 0; i < array.getSize(); i++){
            sb.append(array.get(i));
            if(i != array.getSize() - 1){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
