package com.nzpq.$02stack;

/**栈
 * @author 鹏
 * @Date 2020-10-14 21:35
 */
public interface Stack<E> {

    /**
     * @return 元素数量
     */
    int getSize();

    /**
     * @return 栈是否为空
     */
    boolean isEmpty();

    /**
     * @param e 进栈的元素
     */
    void push(E e);

    /**
     * @return 出栈的元素
     */
    E pop();

    /**
     *
     * @return 查看栈顶的元素
     */
    E peek();
}
