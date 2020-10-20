package com.nzpq.$03queue;

/**
 * @author 鹏
 * @Date 2020-10-15 10:18
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for(int i = 0; i < 8; i++){
            queue.enqueue(i);
        }

        System.out.println(queue.getFront());
        System.out.println(queue.isEmpty());
        System.out.println(queue.getSize());
        System.out.println(queue.getCapacity());
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
