package org.mirai.sword;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mirau on 2021/3/28.
 * @version 1.0
 */
public class Q06ReversePrintList {

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        recursion(head, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * 思路一：使用栈
     *
     * @param head 链表
     * @return 反转后的链表
     */
    private int[] useStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        int size = 0;
        ListNode data = head;
        while (data != null) {
            stack.push(data);
            data = data.next;
            size++;
        }
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop().val;
        }
        return arr;
    }

    /**
     * 使用递归
     *
     * @param head 链表
     * @param list 反转后链表数组
     */
    private void recursion(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        recursion(head.next, list);
        list.add(head.val);
    }

    class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

