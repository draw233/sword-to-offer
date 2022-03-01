package org.mirai;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String[] arr = {"bb", "bbbc", "ab"};

        Arrays.sort(arr);
//        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Hello World!");
    }

    public static void chooseSort(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdex].compareTo(arr[j]) > 0) {
                    minIdex = j;
                }
            }
            if (minIdex != i) {
                extracted(arr, i, minIdex);
            }
        }
    }

    private static void extracted(String[] arr, int i, int minIdex) {
        String temp = arr[minIdex];
        arr[minIdex] = arr[i];
        arr[i] = temp;
    }

    public static void bubbleSort(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 大的沉底
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    extracted(arr, j, j + 1);
                }
            }
        }
    }
}
