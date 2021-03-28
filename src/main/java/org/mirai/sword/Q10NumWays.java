package org.mirai.sword;

/**
 * @author mirau on 2021/3/28.
 * @version 1.0
 */
public class Q10NumWays {

    class Solution {
        public int numWays(int n) {
            if (n <= 1) {
                return 1;
            }
            int[] arr = {1, 2};
            int way;
            for (int i = 3; i <= n; i++) {
                way = (arr[0] + arr[1]) % 1000000007;
                arr[0] = arr[1];
                arr[1] = way;
            }
            return arr[1];
        }
    }
}
