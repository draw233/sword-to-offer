package org.mirai.sword.stack;

/**
 * @author mirau on 2021/4/15.
 * @version 1.0
 */
public abstract class MyStack<E> {

    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    abstract boolean push(E ele);

    abstract E peek();

    abstract E pop();

}
