package org.mirai.sword;

import java.util.Arrays;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class Q47 {
    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     *  
     * <p>
     * 提示：
     * <p>
     * 0 < grid.length <= 200
     * 0 < grid[0].length <= 200
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5vokvr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param args
     */

//    static int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    static int[][] grid = {{1, 2, 5}, {3, 2, 1}};

    public static void main(String[] args) {
        dp();
    }

    public static void dp() {
        // 状态转移方程 f(m,n)= max(f(m,n-1),f(m-1,n)+grid[m][n];
        int[][] dp = new int[grid.length][grid[0].length];
        // 初始化边界
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(dp[grid.length - 1][grid[0].length - 1]);
    }
}
