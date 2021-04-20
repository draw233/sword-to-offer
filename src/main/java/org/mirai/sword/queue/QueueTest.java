package org.mirai.sword.queue;

/**
 * @author mirau on 2021/4/20.
 * @version 1.0
 */
public class QueueTest {

    public static void main(String[] args) {
        MyQueue<String> queue = new ListNodeQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue("data" + i);
        }
        System.out.println(queue.dequeue());
        queue.enqueue("hello");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
