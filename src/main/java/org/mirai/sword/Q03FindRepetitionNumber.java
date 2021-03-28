package org.mirai.sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mirau on 2021/3/27.
 * @version 1.0
 */
public class Q03FindRepetitionNumber {

    public int findRepeatNumber(int[] nums) {

        return useSort(nums);
    }

    /**
     * 思路一：先将数组排序，然后在比较相邻的两个数是否相同
     * 复杂度：空间复杂度 O(logN) ；时间复杂度 O(nlogN)
     *
     * @param nums nums
     * @return repeat num
     */
    private int useSort(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }


    /**
     * 思路二：使用hash表。遍历数组，将值放到 Set 集合中，如果返回成功则继续，失败则表示该值重复
     * 复杂度：空间复杂度 O(n)；时间复杂度 O(n)
     *
     * @param nums nums
     * @return the repeat num
     */
    private int userOtherSpace(int[] nums) {
        Set<Integer> set = new HashSet<>((int) (nums.length / .75f) + 1);

        for (int num : nums) {
            boolean noExist = set.add(num);
            if (!noExist) {
                return num;
            }
        }
        return -1;
    }
}
