package org.mirai.hj;

import java.util.List;
import java.util.Scanner;

/**
 * @author mirau on 2022/2/28.
 * @version 1.0
 */
public class HJ48 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int first = sc.nextInt();
        MyNode myNode = new MyNode(first);
        for (int i = 0; i < size - 1; i++) {
            int val = sc.nextInt();
            int before = sc.nextInt();
            System.out.println(val + " " + before);
            myNode.insert(before, val);
        }
        int del = sc.nextInt();
        myNode.del(del);
        myNode.print();
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class MyNode {
    // 辅助指针
    ListNode head = new ListNode(-1);

    public MyNode(){}

    public MyNode(int val) {
        head.next = new ListNode(val);
    }

    public ListNode toNode() {
        return head.next;
    }

    public void addLast(int val) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);

    }

    public void insert(int before, int value) {
        ListNode temp = head.next;
        while (temp != null) {
            if (temp.val == before) {
                ListNode newNode = new ListNode(value);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void del(int val) {
        ListNode before = head;
        ListNode temp = before.next;
        while (temp != null) {
            if (temp.val == val) {
                before.next = temp.next;
                return;
            }
            before = temp;
            temp = temp.next;
        }
        System.out.println("del不 存在");
    }

    public void print() {
        ListNode temp = head.next;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

}