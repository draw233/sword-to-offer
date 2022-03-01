package org.mirai.hj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class HJ26 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLowerCase(c) || Character.isUpperCase(c)) {
                    list.add(c);
                }
            }
            // 对list排序
            list.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    char c1 = Character.toLowerCase(o1);
                    char c2= Character.toLowerCase(o1);
                    return c1 - c2;
                }
            });

            int cour = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLowerCase(c) || Character.isUpperCase(c)) {
                    System.out.print(list.get(cour++));
                } else {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
