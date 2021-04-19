package org.mirai.sword.heap;

import java.util.Arrays;

/**
 * @author mirau on 2021/4/19.
 * @version 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 519, 2, 10, 8, 0, 998};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 自下而上堆排序
     *
     * @param arr 待排序数组
     */
    public static void heapSort(int[] arr) {
        // 1.建立大顶堆
        buildMaxHead(arr);
        for (int len = arr.length - 1; len >= 0; len--) {
            // 2.交换头尾元素
            swap(arr, 0, len);
            // 3.将[0,len)的元素继续堆化
            heapify(arr, 0, len);
        }
    }

    /**
     * 建立大顶堆
     *
     * @param arr arr
     */
    private static void buildMaxHead(int[] arr) {
        // 第一个非叶子节点
        int index = (arr.length >> 1) - 1;
        // 从第一个非叶子节点开始,从右向左，建立大顶堆
        for (int i = index; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    /**
     * 从节点 i 开始，与子节点比较、交换，堆化
     *
     * @param arr    数组
     * @param i      节点索引
     * @param length 参与堆化的节点长度
     */
    private static void heapify(int[] arr, int i, int length) {
        // 父节点值
        int pValue = arr[i];
        for (int j = (i << 1) + 1; j < length; j = (j << 1) + 1) {
            // 假设左节点为较大值
            int child = j;
            int right = j + 1;
            // 比较左右子几点，取较大值的索引下标
            if (right < length && arr[child] < arr[right]) {
                child = right;
            }

            // 比较父节点和子节点大小
            if (arr[child] > pValue) {
                arr[i] = arr[child];
                i = child;
            } else {
                break;
            }
        }
        arr[i] = pValue;
    }

    /**
     * 通过异或交换元素
     *
     * @param arr 数组
     * @param a   下标
     * @param b   下标
     */
    private static void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
