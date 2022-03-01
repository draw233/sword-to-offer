package org.mirai.dp;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class Qiwa {

    public static void main(String[] args) {
        System.out.println(clamp(7));
    }

    public static int clamp(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
