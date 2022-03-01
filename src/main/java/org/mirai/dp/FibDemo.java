package org.mirai.dp;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class FibDemo {

    public static void main(String[] args) {

        System.out.println(fibonacci(5));
        System.out.println(fib2(5));
        System.out.println(dp(5));

    }

    /**
     * 递归求斐波那契数列
     * 问题：
     * 1.有太多重复计算
     */
    public static int fibonacci(int i) {
        if (i <= 1) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    public static int fib2(int n) {
        // 用记事本
        int[] pack = new int[2];
        pack[0] = 1;
        pack[1] = 1;
        if (n <= 1) {
            return 1;
        }
        int sum = 0;
        for (int j = 2; j <= n; j++) {
            sum = pack[0] + pack[1];
            pack[0] = pack[1];
            pack[1] = sum;
        }
        return sum;
    }

    public static int dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
