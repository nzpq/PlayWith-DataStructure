package com.nzpq.$03queue;

/**
 * @author 鹏
 * @Date 2020-10-15 10:09
 */
public interface Queue<E> {

    /**
     *
     * @return queue存储元素的大小
     */
    int getSize();

    /**
     *
     * @return queue最大容量
     */
    int getCapacity();

    boolean isEmpty();

    /**
     * 进队列
     * @param e 进队列的元素
     */
    void enqueue(E e);

    /**
     * 出队列
     * @return 出队列的元素
     */
    E dequeue();

    /**
     * 查看队列头元素
     * @return 队列头元素
     */
    E getFront();
}
