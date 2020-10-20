package com.nzpq.$02stack;

/**
 * @author 鹏
 * @Date 2020-10-14 21:54
 */
public class StackDemo {

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        System.out.println(stack);

        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());

        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        ;

    }
}
