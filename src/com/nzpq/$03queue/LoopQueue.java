package com.nzpq.$03queue;

/**循环队列
 * @author 鹏
 * @Date 2020-10-15 13:45
 */
public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int front;//指向队列的第一个元素
    private int tail;//指向循环队列最后一个元素的下一个位置
    private int size;//循环队列的元素个数

    public LoopQueue(int capacity){
        //预留一个空间，不存储数据
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
       this(10);
    }

    /**
     *
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    /**
     *
     * @return 队列中元素的个数
     */
    @Override
    public int getSize(){
        return size;
    }

    /**
     *
     * @return 队列的容量
     */
    @Override
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 入队
     * @param e 进队列的元素
     */
    @Override
    public void enqueue(E e) {
        //判断队列是否已满
        if((tail + 1) % data.length == front){
            //扩容
            resize(getCapacity() * 2);
        }
        //入队
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 改变队列容量的方法
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity){
        E[] newData = (E[])  new Object[newCapacity + 1];
        //遍历原始数组，复制元素到新数组
        //第一种遍历循环队列的方法，从0开始，下边toString方法有另一种方法
        for(int i = 0; i < size; i++){
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        //判断队列是否为空
        if(isEmpty()){
            throw new IllegalArgumentException("循环队列为空");
        }
        //临时存储出队的元素
        E returnVal = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        //当元素减少到数组容量一半的时候，数组缩容
        //注意：缩容的大小不能是0
        if(size ==  getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return returnVal;
    }

    @Override
    public E getFront() {
        //判断队列是否为空
        if(isEmpty()){
            throw new IllegalArgumentException("循环队列为空");
        }
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("loopQueue：size = %d , capacity = %d\n",size,data.length - 1));
        sb.append("front [");
        //第二种遍历循环队列的方法
        for(int i = front; i != tail; i = (i + 1) % data.length){
            sb.append(data[i]);
            //判断是否为最后一个元素
            if((i + 1) % data.length != tail){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

}
