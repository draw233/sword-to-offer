package org.mirai.hj;

import java.util.Scanner;

/**
 * @author mirau on 2022/2/28.
 * @version 1.0
 */
public class HJ51 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        MyNode myNode = new MyNode();
        for (int i = 0; i < size; i++) {
            int val = sc.nextInt();
            myNode.addLast(val);
        }

        myNode.print();
        int k = sc.nextInt();
        ListNode qNode = myNode.toNode();
        ListNode sNode = qNode;
        while (k > 0) {
            qNode = qNode.next;
            k--;
        }
        // 快慢指针
        while (qNode != null) {
            qNode = qNode.next;
            sNode = sNode.next;
        }
        System.out.println(sNode == null ? 0 : sNode.val);

    }

}
