package org.mirai.sword.stack;

/**
 * @author mirau on 2021/4/15.
 * @version 1.0
 */
public class StackTest {
    public static void main(String[] args) {
//        MyStack<String> stack = new ArrayStack<>();
        MyStack<String> stack = new ListNodeStack<>();
        for (int i = 0; i < 5; i++) {
            if (!stack.push("data" + i)) {
                break;
            }
        }
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push("hezhou");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
