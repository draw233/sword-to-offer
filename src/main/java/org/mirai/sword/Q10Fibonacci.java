package org.mirai.sword;

/**
 * @author mirau on 2021/3/28.
 * @version 1.0
 */
public class Q10Fibonacci {

    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.fib(48));
        }

        public int fib(int n) {
            return useIterator(n);
        }

        /**
         * 使用递归
         *
         * @param n 第几个数
         * @return fibonacci 值
         */
        private int recursion(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return recursion(n - 2) + recursion(n - 1);
            }
        }

        /**
         * 使用循环
         *
         * @param n 第几个数
         * @return fibonacci 值
         */
        private int useIterator(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            // 每次都要计算都需要用到前面的两个值，所以将其保存
            int[] value = {0, 1};
            int calculate = 0;
            for (int i = 2; i <= n; i++) {
                calculate = (value[0] + value[1]) % 1000000007;
                value[0] = value[1];
                value[1] = calculate;
            }

            return calculate;
        }


    }
}
