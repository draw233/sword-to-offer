package org.mirai.sort;

/**
 * @author mirau on 2021/4/2.
 * @version 1.0
 */
public class Utils {

    public static void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
