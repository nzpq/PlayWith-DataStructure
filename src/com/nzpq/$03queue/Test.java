package com.nzpq.$03queue;


import java.util.Random;

/**
 * 测试数组队列和循环队列的效率
 * @author 鹏
 * @Date 2020-10-15 16:34
 */
public class Test {

    public static void main(String[] args) {

        int count = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = test(arrayQueue, count);
        System.out.println("arrayQueue: "+time1); //4.4449077

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = test(loopQueue, count);
        System.out.println("loopQueue: "+time2); //0.0167332
    }

    /**
     *
     * @param queue 数组队列 or 循环队列
     * @param count 执行的次数
     * @return 执行完所需的时间，单位：秒
     */
    private static double test(Queue<Integer> queue,int count){
        //毫秒
        long start = System.nanoTime();
        //入队
        Random random = new Random();
        for(int i = 0; i <= count; i++){
            //表示生成从0到Integer最大值之间的随机数
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        //出队
        for(int i = 0; i <= count; i++){
            queue.dequeue();
        }
        //结束计时
        long end = System.nanoTime();

        //纳秒转化为秒
        return (end - start) / 1000000000.0;
    }


}
