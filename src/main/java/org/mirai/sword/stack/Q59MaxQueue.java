package org.mirai.sword.stack;

import java.util.LinkedList;

/**
 * @author mirau on 2021/4/10.
 * @version 1.0
 */
public class Q59MaxQueue {
    public static void main(String[] args) {
        System.out.println(1L << 40);
    }

    class MaxQueue {

        private Integer[] queue;
        private LinkedList<Integer> dqueue =new LinkedList<>();
        int size = 10;
        int insert = 0;
        int remove = 0;

        public MaxQueue() {
            queue = new Integer[size];
        }

        public int max_value() {
            if (dqueue.isEmpty()) {
                return -1;
            } else {
                return dqueue.getFirst();
            }
        }

        public void push_back(int value) {
            while (!dqueue.isEmpty() && dqueue.getLast() < value) {
                dqueue.removeLast();
            }
            dqueue.add(value);
            queue[insert++] = value;
            // wrap
            if (insert == size) {
                insert = 0;
            }

            if (insert == remove) {
                // 扩容
                int maxI = size * 2;
                Integer[] newQueue = new Integer[maxI];
                System.arraycopy(queue, insert, newQueue, 0, size - insert);
                System.arraycopy(queue, 0, newQueue, size - insert, insert);
                insert = size;
                remove = 0;
                queue = newQueue;
                size = maxI;
            }

        }

        public int pop_front() {
            if (insert == remove) {
                // 空的
                return -1;
            }
            int result = queue[remove];
            queue[remove] = -1;
            remove++;

            //wrap
            if (remove == size) {
                remove = 0;
            }
            if (dqueue.getFirst() == result) {
                dqueue.removeFirst();
            }
            return result;
        }

    }
}
