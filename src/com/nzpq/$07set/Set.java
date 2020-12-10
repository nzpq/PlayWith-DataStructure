package com.nzpq.$07set;

/**
 * @author 鹏
 * @date 2020-10-26 10:04
 */
public interface Set<E> {

    boolean isEmpty();

    boolean contains(E e);

    void add(E e);

    void remove(E e);

    int getSize();
}
