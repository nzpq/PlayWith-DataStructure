package com.nzpq.$04linkledist;

import com.nzpq.$03queue.Queue;

/**
 * 链表实现队列
 * @author 鹏
 * @Date 2020-10-17 15:49
 */
public class LinkedListQueue<E> implements Queue<E> {

    //节点内部类
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head; //指向头节点
    private Node tail; //指向链表最后一个节点
    private int size; //队列长度

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 链表没有容量，这个方法是之前用数组实现队列使用的，就当这个方法不存在
     * @return xxx
     */
    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            //此时链表为空
            tail = new Node(e);
            head = tail;
        }else{
            //链表不为空
            tail.next = new Node(e);
            tail = tail.next; //tail后移，
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        //判断队列的元素是否全都出队了
        if(head == null){
            //所有元素都已经出队，此时队列为空，让tail为null
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("linkedQueue: front ");
        //遍历链表
        Node current = head;
        while(current != null){
            sb.append(current).append("-->");
            current = current.next;
        }
        sb.append(" null tail");
        return sb.toString();
    }
}
