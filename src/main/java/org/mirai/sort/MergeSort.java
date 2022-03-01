package org.mirai.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author mirau on 2022/3/2.
 * @version 1.0
 */
public class MergeSort {

    public static void main(String[] args) {
        int size = 12;
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int l, int r) {
        // 当只有一个元素，无需任何操作
        if (l >= r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        mergeTwoSortedArray(arr, l, mid, r);
    }

    private static void mergeTwoSortedArray(int[] arr, int l, int mid, int r) {
        // 新建一个数组
        int len = r - l + 1;
        int[] temp = new int[len];

        // 左边数组起始位置
        int left = l;
        // 右边数组起始位置
        int tempIndex = 0;
        int right = mid + 1;
        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[tempIndex++] = arr[left++];
            } else {
                temp[tempIndex++] = arr[right++];
            }
        }

        // 最后如果还有未添加的数组
        while (left <= mid) {
            temp[tempIndex++] = arr[left++];
        }
        while (right <= r) {
            temp[tempIndex++] = arr[right++];
        }
        // 把temp 数组赋值到原来数组
        System.arraycopy(temp, 0, arr, l, len);
    }
}
