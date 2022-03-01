package org.mirai.hj;

import org.mirai.App;

import java.util.Scanner;

/**
 * @author mirau on 2022/2/28.
 * @version 1.0
 */
public class HJ14 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] arrs = new String[size];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = sc.next();
        }
        sc.close();
        App.bubbleSort(arrs);
        for (String arr : arrs) {
            System.out.println(arr);
        }

    }

}
