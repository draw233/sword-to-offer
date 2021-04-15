package org.mirai.sword.stack;

/**
 * @author mirau on 2021/4/15.
 * @version 1.0
 */
public class ArrayStack<E> extends MyStack<E> {

    private final Object[] elementData;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        this.elementData = new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == elementData.length;
    }

    @Override
    public boolean push(E ele) {
        if (isFull()) {
            return false;
        }
        elementData[size++] = ele;
        return true;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E ele = (E) elementData[size - 1];
        return ele;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E ele = (E) elementData[--size];
        return ele;
    }
}
