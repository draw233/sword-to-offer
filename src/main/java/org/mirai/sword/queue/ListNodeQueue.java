package org.mirai.sword.queue;

/**
 * @author mirau on 2021/4/20.
 * @version 1.0
 */
public class ListNodeQueue<E> extends MyQueue<E> {

    private ListNode<E> head;
    private ListNode<E> tail;

    /**
     * 将元素插到链表尾部
     *
     * @param ele 元素
     * @return boolean
     */
    @Override
    public boolean enqueue(E ele) {
        ListNode<E> eListNode = new ListNode<>(ele);
        if (head == null) {
            head = eListNode;
            tail = eListNode;
        } else {
            tail.next = eListNode;
            tail = eListNode;
        }
        size++;
        return true;
    }

    @Override
    public E dequeue() {
        if (head == null) {
            return null;
        }
        E ele = head.data;
        head = head.next;
        // 这里要对tail 判断
        if (head == null) {
            tail = null;
        }
        size--;
        return ele;
    }

    private static class ListNode<E> {
        private E data;
        private ListNode<E> next;

        public ListNode(E data) {
            this.data = data;
        }
    }
}
