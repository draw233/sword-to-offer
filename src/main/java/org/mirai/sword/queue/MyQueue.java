package org.mirai.sword.queue;

/**
 * @author mirau on 2021/4/20.
 * @version 1.0
 */
public abstract class MyQueue<E> {

    int size;

    public abstract boolean enqueue(E t);

    public abstract E dequeue();

    public boolean isEmpty() {
        return size == 0;
    }
}
