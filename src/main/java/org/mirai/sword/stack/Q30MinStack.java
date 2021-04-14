package org.mirai.sword.stack;

import java.util.Stack;

/**
 * @author mirau on 2021/4/14.
 * @version 1.0
 */
public class Q30MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }

    static class MinStack {

        private int defaultSize = 10;

        private int[] data;

        private Stack<Integer> stack = new Stack<>();

        private int putIndex = 0;
        private int len = 0;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new int[defaultSize];
        }

        public void push(int x) {
            if (stack.isEmpty() || stack.peek() >= x) {
                stack.push(x);
            }
            data[putIndex++] = x;
            len++;
            if (defaultSize == len) {
                // 扩容
                int newSize = defaultSize << 1;
                int[] newArr = new int[newSize];
                System.arraycopy(data, putIndex, newArr, 0, defaultSize - putIndex);
                System.arraycopy(data, 0, newArr, defaultSize - putIndex, putIndex);
                putIndex = defaultSize;
                defaultSize = newSize;
                data = newArr;
            }
        }

        public void pop() {
            len--;

            if (len == -1) {
                return;
            }
            int ele = data[--putIndex];
            if (!stack.isEmpty() && ele == stack.peek()) {
                stack.pop();
            }
        }

        public int top() {
            return data[putIndex - 1];
        }

        public int min() {
            if (stack.isEmpty()) {
                return -1;
            } else {
                return stack.peek();
            }

        }
    }
}
