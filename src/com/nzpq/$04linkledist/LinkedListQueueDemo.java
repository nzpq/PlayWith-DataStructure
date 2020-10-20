package com.nzpq.$04linkledist;

/**
 * 测试LinkedListQueue
 * @author 鹏
 * @Date 2020-10-17 16:22
 */
public class LinkedListQueueDemo {

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        for(int i = 0; i < 5; i++){
            queue.enqueue(i);
        }
        System.out.println(queue);

        System.out.println("queue size "+queue.getSize());
        System.out.println("queue is null ?  "+queue.isEmpty());
        System.out.println("queue front ==》 "+queue.getFront());
        System.out.println("queue 出队 "+queue.dequeue());
        System.out.println(queue.toString());

    }
}
