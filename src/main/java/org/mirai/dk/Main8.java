package org.mirai.dk;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class Main8 {

    public static void main(String[] args) {
         /*
        输入一个英文文章片段
        翻转指定区域的单词顺序
        标点符号和普通字母一样处理
        例如输入字符串 I am a developer.
        [0,3]
        则输出 developer. a am I

        输入描述
         使用换行隔开3个参数
         第一个参数为文章内容 即英文字符串
         第二个参数为翻转起始单词下标，下标从0开始
         第三个参数为结束单词下标

         输出描述

         翻转后英文文章片段每个单词之间以一个半角空格分割输出

         例子

          输入
           I am a developer.
           0
           3
          输出
           I a am developer.

          输入
            hello world!
          0
          3
          输出
          world! hello

输入字符串可以在前面或者后面包含多个空格
但是翻转后的字符不能包括

指定反转区间只有一个单词
或无有效单词
则输出EMPTY

         */

        m1();
    }

    private static void m1() {
        Scanner sc = new Scanner(System.in);
        List<String> collect = Arrays.stream(sc.nextLine().trim().split("\\s")).collect(Collectors.toList());
        int start = sc.nextInt();
        int end = sc.nextInt();
        sc.close();
        StringBuilder sb = new StringBuilder();
        String empty = " ";
        int r = Math.min(end, collect.size() - 1);
        for (int j = 0; j < collect.size(); j++) {
            // 这里根据边界翻转
            if (j >= start && j <= end) {
                sb.append(collect.get(r--)).append(empty);
                continue;
            }
            sb.append(collect.get(j)).append(empty);

        }
        System.out.println(sb);
    }
}
