package org.mirai.list;

import java.util.ArrayDeque;

/**
 * @author mirau on 2022/2/28.
 * @version 1.0
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = createNode();
        printNode(head);
        ListNode listNode = reverseNodeB(head);
        printNode(listNode);

    }

    private static ListNode createNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        return listNode1;
    }

    public static void printNode(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    /**
     * 通过栈反转链表
     */
    public static ListNode reverseListByStack(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            queue.push(temp.val);
            temp = temp.next;
        }
        ListNode ret = new ListNode(queue.pop());
        ListNode next = ret;
        while (queue.peek() != null) {
            next.next = new ListNode(queue.pop());
            next = next.next;
        }

        return ret;
    }

    /**
     * 遍历法
     */
    public static ListNode reverseNodeB(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}