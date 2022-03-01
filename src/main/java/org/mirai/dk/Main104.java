package org.mirai.dk;

import java.util.Scanner;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class Main104 {

    public static void main(String[] args) {
/*
    有一个特殊的五键键盘
    上面有A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A
    A键在屏幕上输出一个字母A
    Ctrl-C将当前所选的字母复制到剪贴板
    Ctrl-X将当前选择的字母复制到剪贴板并清空所选择的字母
    Ctrl-V将当前剪贴板的字母输出到屏幕
    Ctrl-A选择当前屏幕中所有字母
    注意：
      1. 剪贴板初始为空
      2. 新的内容复制到剪贴板会覆盖原有内容
      3. 当屏幕中没有字母时,Ctrl-A无效
      4. 当没有选择字母时Ctrl-C、Ctrl-X无效
      5. 当有字母被选择时A和Ctrl-V这两个输出功能的键,
         会先清空所选的字母再进行输出

    给定一系列键盘输入,
    输出最终屏幕上字母的数量

    输入描述:
       输入为一行
       为简化解析用数字12345分别代替A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A的输入
       数字用空格分割

    输出描述:
        输出一个数字为屏幕上字母的总数量

    示例一:
        输入:
          1 1 1
        输出:
          3

   示例二:
        输入:
          1 1 5 1 5 2 4 4
        输出:
          2
   */

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        Mysoft mysoft = new Mysoft();
        for (String s2 : s1) {
            switch (s2) {
                case "1":
                    mysoft.add();
                    break;
                case "2":
                    mysoft.cc();
                    break;
                case "3":
                    mysoft.cx();
                    break;
                case "4":
                    mysoft.cv();
                    break;
                default:
                    mysoft.ca();
                    break;
            }
        }

        System.out.println(mysoft.sb);

    }


}

class Mysoft {

    StringBuilder sb = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    StringBuilder ca = new StringBuilder();
    static char aChar = 'A';

    public void add() {
        if (ca.length() > 0) {
            sb.setLength(0);
        }
        sb.append(aChar);
        ca.setLength(0);
    }

    public void cc() {
        if (ca.length() > 0) {
            temp.append(ca);
        }
    }

    public void cx() {
        if (ca.length() > 0) {
            temp.append(ca);
            sb.setLength(0);
        }
    }

    public void cv() {
        if (ca.length() > 0) {
            sb.setLength(0);
            sb.append(ca);
        } else {
            sb.append(temp.toString());
        }
        ca.setLength(0);
    }

    public void ca() {
        ca.append(sb.toString());
    }


}
