package com.nzpq.$04linkledist;

/**
 * 测试基于链表的栈
 * @author 鹏
 * @Date 2020-10-17 13:26
 */
public class LinkedListStackDemo {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        Integer pop = stack.pop();
        System.out.println("弹栈 "+pop);
        System.out.println(stack);

        System.out.println("stack的size "+stack.getSize());
        System.out.println("stack是否为空 "+stack.isEmpty());
        System.out.println("stack头元素 "+stack.peek());

    }
}
