package org.mirai.sword;

import java.util.Arrays;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class Q60 {

    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     * <p>
     *  
     * <p>
     * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1
     * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
     * 示例 2:
     * <p>
     * 输入: 2
     * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
     *  
     * <p>
     * 限制：
     * <p>
     * 1 <= n <= 11
     * <p>
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/ozzl1r/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] ints = new int[10];
        Arrays.fill(ints, 1);

    }

    public double[] dicesProbability(int n) {
        //
        int[] sum = new int[n * 5 + 1];
        sum[0] = 1;
        for (int i = 1; i < 6; i++) {
            sum[i] = 1;
        }


        double[] d = new double[n * 5 + 1];


        return d;
    }
}
