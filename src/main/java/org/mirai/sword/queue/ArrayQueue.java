package org.mirai.sword.queue;

/**
 * @author mirau on 2021/4/20.
 * @version 1.0
 */
public class ArrayQueue<E> extends MyQueue<E> {

    private final Object[] elements;

    private int head;
    private int tail;

    private final int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue() {
        this.capacity = DEFAULT_CAPACITY;
        this.elements = new Object[capacity];
    }

    public ArrayQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity is negative");
        }
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    @Override
    public boolean enqueue(E e) {
        // 检查数组是否满了
        if (size == capacity) {
            return false;
        }
        elements[tail++] = e;
        // 域下面的 tail = (tail+1)%capacity 实现结果一样
        ///  if (tail == capacity) {
        //      tail = 0;
        //  }
        tail = tail % capacity;
        ++size;
        return true;
    }

    @Override
    public E dequeue() {
        // 检查数组是否为空
        if (size == 0) {
            return null;
        }
        E ele = (E) elements[head++];
        /// head = head%capacity
        if (head == capacity) {
            head = 0;
        }
        --size;
        return ele;
    }
}
