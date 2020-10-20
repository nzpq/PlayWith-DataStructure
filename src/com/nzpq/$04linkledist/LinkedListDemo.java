package com.nzpq.$04linkledist;

/**
 * 测试LinkedList
 * @author 鹏
 * @Date 2020-10-16 22:48
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i = 0; i < 10; i++){
            linkedList.addLast(i);
        }

        linkedList.add(2,22);
        linkedList.addFirst(11);

        System.out.println(linkedList);
        System.out.println("linkedList是否包含 11 "+linkedList.contains(11));
        System.out.println("linkedList头元素 "+linkedList.getFirst());
        System.out.println("linkedList尾元素 "+linkedList.getLast());
        System.out.println("linkedList索引为 2 的元素 "+linkedList.get(2));
        System.out.println("linkedList的长度 "+linkedList.getSize());
        System.out.println("linkedList是否为空 "+linkedList.isEmpty());

        //修改
        linkedList.set(2,222);
        System.out.println(linkedList);
        System.out.println("*************************");

        //删除索引为2的元素
        System.out.println("删除索引为2的元素 "+linkedList.remove(2));
        System.out.println(linkedList);
        System.out.println("删除头元素 "+linkedList.removeFirst());
        System.out.println(linkedList);
        System.out.println("删除尾元素 "+linkedList.removeLast());
        System.out.println(linkedList);
    }
}
