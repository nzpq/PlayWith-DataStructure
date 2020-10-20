package com.nzpq.$04linkledist;

/**
 * @author 鹏
 * @Date 2020-10-15 22:55
 * 自定义LinkedList
 */
public class LinkedList<E> {

    //节点内部类
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
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

    //虚拟头节点，不存储元素
    private Node dummyHead;
    //链表存储元素的个数
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * @return 链表长度
     */
    public int getSize(){
        return size;
    }

    /**
     *
     * @return 链表是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 指定索引处添加节点
     * @param index 指定索引
     * @param e 元素
     */
    public void add(int index,E e){
        //判断索引是否合法
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引不合法");
        }

        //辅助遍历，定位到要插入索引的前一个节点
        Node prev = dummyHead;
        //遍历index次
        for (int i = 0; i < index; i++) {
            //节点后移
            prev = prev.next;
        }
        //遍历完毕，找到了要插入索引位置的前一个节点
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        /*
            相当于以上三行代码
            new Node(e,prev.next) ==》  Node node = new Node(e); node.next = prev.next;
            prev.next = new Node(e,prev.next);  ==》  prev.next = node;
         */
        prev.next = new Node(e,prev.next);
        size++;
    }
    /**
     * 向链表头部添加节点
     * @param e 头
     */
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        /*  相当于以上三行代码
            new Node(e,head)  存储e元素节点的next指向head
            head = new Node(e,head) 让头节点指向新插入的节点
         */
//        head = new Node(e,head);
//        size++;

        add(0,e);
    }

    /**
     *
     * @param e 链表末尾添加的元素
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 返回指定索引处的元素，实际中这个方法并不常用，这里只是用来练习
     * @param index 索引
     * @return 返回的元素
     */
    public E get(int index){
        //判断索引是否合法
        if(index < 0 || index >= size){
            throw new  IllegalArgumentException("索引非法");
        }
        //定义一个辅助遍历变量，从索引0开始
        Node current = dummyHead.next;
        for (int i = 0; i < index ; i++) {
            current = current.next;
        }
        return current.e;
    }

    /**
     *实际中这个方法并不常用，这里只是用来练习
     * @return 获取第一个元素
     */
    public E getFirst(){
        return get(0);
    }

    /**
     *实际中这个方法并不常用，这里只是用来练习
     * @return 获取最后一个元素
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改指定索引处的元素，实际中这个方法并不常用，这里只是用来练习
     * @param index 索引
     * @param e 修改的元素
     */
    public void set(int index,E e){
        //索引判断
        if(index < 0 || index >= size){
            throw new  IllegalArgumentException("索引非法");
        }
        //遍历找到被修改的元素
        Node current = dummyHead.next;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        current.e = e;
    }

    /**
     * 判断链表中是否包含元素
     * @param e 是否包含e
     * @return true or false
     */
    public boolean contains(E e){
        //判断链表是否为空
        if(isEmpty()){
            throw new  IllegalArgumentException("链表为空");
        }
        //从索引0处开始遍历
        //辅助遍历
        Node current = dummyHead.next;

        //for循环遍历
//        for (int i = 0; i < size; i++) {
//            if(current.e.equals(e)){
//                return true;
//            }
//            current = current.next;
//        }

        //第二种：while循环遍历
        while(current != null){
            if(current.e.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node current = dummyHead.next;
        while(current != null){
           sb.append(current).append("->");
           current = current.next;
        }
        sb.append(" null");
        return sb.toString();
    }

    /**
     * 删除指定索引处的元素
     * @param index 索引
     * @return 被删除的元素
     */
    public E remove(int index){
        //判断链表是否为空
        if(isEmpty()){
            throw new  IllegalArgumentException("链表为空");
        }
        //遍历找到被删除元素的前一个元素
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        E returnVal = prev.next.e;
        prev.next = prev.next.next;
        size--;
        return returnVal;
    }

    /**
     *
     * @return 删除头节点
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     *
     * @return 删除尾节点
     */
    public E removeLast(){
        return remove(size - 1);
    }
}
