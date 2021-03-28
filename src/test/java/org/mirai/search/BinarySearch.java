package org.mirai.search;

import org.junit.Before;
import org.junit.Test;

/**
 * @author mirau on 2021/3/27.
 * @version 1.0
 */
public class BinarySearch {

    int[] arr;

    @Before
    public void init() {
        arr = new int[]{1, 2, 4, 5, 6, 7};
    }

    @Test
    public void testBinarySearch() {
        System.out.println(binarySearch(arr, 99));
    }

    /**
     * 二分查找：时间复杂度 O(logN) ,空间复杂度 O(1)
     *
     * @param nums   array
     * @param target the value need to find
     * @return index of the value , -1 means does not exits
     */
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = arr.length - 1;
        int pivot;
        while (left <= right) {
            pivot = ((right - left) >>> 1) + left;
            System.out.println("pivot= " + pivot);
            if (nums[pivot] == target) {
                return pivot;
            }
            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

}
