package com.nzpq.$03queue;

/**
 * @author 鹏
 * @Date 2020-10-15 15:47
 */
public class LoopQueueDemo {

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();

        for(int i = 0; i < 8; i++){
            queue.enqueue(i);
        }
        System.out.println(queue);
//        System.out.println(queue.getCapacity());
//        System.out.println(queue.getSize());
//        System.out.println(queue.getFront());
//        System.out.println(queue.isEmpty());


        //验证缩容
        for (int i = 0; i < 6; i++){
            queue.dequeue();
        }
        System.out.println(queue);

        //验证扩容
        for(int i = 0; i < 8; i++){
            queue.enqueue(i);
        }
        System.out.println(queue);
    }
}
