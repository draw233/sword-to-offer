package org.mirai.sort;

import java.util.Arrays;

/**
 * @author mirau on 2022/3/2.
 * @version 1.0
 */
public class Sort {

    static int nums[] = {1, 3, 5100, 2, 100, 0, 199};

    public static void main(String[] args) {

        System.out.println(Arrays.toString(nums));
        quicklySort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));


    }

    /**
     * 选择排序
     */
    public static void chooseSort() {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(nums, minIndex, i);
            }
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort() {
        boolean noSwap = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    noSwap = false;
                }
            }
            if (noSwap) {
                break;
            }

        }
    }

    public static void quicklySort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition2(arr, l, r);
        quicklySort(arr, l, pivot - 1);
        quicklySort(arr, pivot + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivotIndex = l;
        int pivot = arr[l];
        while (l < r) {
            // 以最左边为基准值，所以从右边开始,找到比基准值小的元素
            while (arr[r] > pivot && l < r) {
                r--;
            }
            // 坑变成右边
            if (l < r) {
                arr[pivotIndex] = arr[r];
                pivotIndex = r;
            }
            // 从左边找，比基准值大的元素
            while (arr[l] < pivot && l < r) {
                l++;
            }
            // 坑变成左边
            if (l < r) {
                arr[pivotIndex] = arr[l];
                pivotIndex = l;
            }
        }
        arr[pivotIndex] = pivot;
        return pivotIndex;
    }

    public static int partition2(int[] arr, int l, int r) {
        int pivotIndex = l;
        int pivotValue = arr[l];
        while (l < r) {
            while (l < r && arr[r] > pivotValue) {
                r--;
            }
            // 这个<= 是关键
            while (l < r && arr[l] <= pivotValue) {
                l++;
            }
            if (l < r) {
                swap(arr, l, r);
            }
        }
        if (pivotIndex != r) {
            swap(arr, pivotIndex, l);
        }

        return l;

    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
        }
    }
}
