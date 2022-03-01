package org.mirai.sword;

import java.util.Arrays;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class Q42 {

    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * <p>
     * 要求时间复杂度为O(n)。
     * <p>
     *  
     * <p>
     * 示例1:
     * <p>
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10^5
     * -100 <= nums[i] <= 100
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/59gq9c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

    public static void main(String[] args) {
        dp();
        qionju();
    }

    public static void dp() {
        // dp[n] = max(dp[n-1]+n,d) 动态转移方程
        int[] dp = new int[nums.length + 1];
        // 初始值
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max((dp[i - 1] + nums[i]), nums[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        System.out.println(Arrays.toString(dp));

    }

    /**
     * 这是将所有组合都遍历出来求和
     */
    public static void qionju() {
        // f(1)= arr.length-1+1
        // f(2)= arr.length-2+1
        // f(3)= arr.length-3+1
        // f(n)= arr.length-n+1

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int r = j + i + 1;
                if (r > nums.length) {
                    break;
                }
                max = Math.max(max, sum(nums, j, r));
            }
        }
        System.out.println(max);
    }

    public static int sum(int[] nums, int l, int r) {
        int ss = 0;
        for (int i = l; i < r; i++) {
            ss += nums[i];
        }
        return ss;
    }
}
