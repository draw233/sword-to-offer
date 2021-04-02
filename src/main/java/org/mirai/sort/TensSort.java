package org.mirai.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author mirau on 2021/4/2.
 * @version 1.0
 */
public class TensSort {
    private static int[] arr = new int[10];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));
        quicklySort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void quicklySort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partitionBySwap(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    /**
     * 前后指针法
     */
    private static int partitionBySwap(int[] arr, int left, int right) {
        // 以左边第一个数为基准值
        int begin = left;
        int pivotValue = arr[left];
        while (left < right) {
            // 从右边开始，找到比基准值小的数，则退出循环
            while (left < right && arr[right] > pivotValue) {
                right--;
            }
            // 从左边开始，找到比基准值大的数
            while (left < right && arr[left] <= pivotValue) {
                left++;
            }
            if (left < right) {
                Utils.swap(arr, left, right);
            }
        }
        // 要将基准值放在中间
        Utils.swap(arr, begin, left);
        return left;
    }

    /**
     * 站坑法
     */
    private static int partition(int[] arr, int left, int right) {
        // 以左边第一个数为坑
        int pivotValue = arr[left];
        while (left < right) {
            // 从右边开始，找到比坑位小的数
            while (left < right && arr[right] > pivotValue) {
                right--;
            }
            // 占坑
            if (left < right) {
                // right 作为新坑
                arr[left] = arr[right];
            }
            // 从左边开始，找比坑位大的数
            while (left < right && arr[left] <= pivotValue) {
                left++;
            }
            // 占坑
            if (left < right) {
                // left 作为新坑
                arr[right] = arr[left];
            }
        }
        // 将pivotValue的值放到坑位中
        arr[left] = pivotValue;
        return left;
    }
}
