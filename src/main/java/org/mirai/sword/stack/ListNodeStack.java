package org.mirai.sword.stack;

/**
 * @author mirau on 2021/4/15.
 * @version 1.0
 */
public class ListNodeStack<E> extends MyStack<E> {

    private ListNode<E> head;

    @Override
    public boolean push(E ele) {
        ListNode<E> node = new ListNode<>(ele);
        // 往头部加数据
        if (head != null) {
            node.next = head;
        }
        head = node;
        size++;
        return true;
    }

    @Override
    public E peek() {
        // 从头部取数据
        if (head == null) {
            return null;
        } else {
            return head.data;
        }
    }

    @Override
    public E pop() {
        if (head == null) {
            return null;
        } else {
            E data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    /**
     * 单链表
     *
     * @param <E> 数据类型
     */
    private static class ListNode<E> {
        private final E data;
        private ListNode<E> next;

        public ListNode(E data) {
            this.data = data;
        }
    }
}
