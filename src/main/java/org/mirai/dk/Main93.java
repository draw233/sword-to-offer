package org.mirai.dk;

import java.util.*;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class Main93 {

    public static void main(String[] args) {
          /*
   某学校举行运动会,学生们按编号（1、2、3.....n)进行标识,
   现需要按照身高由低到高排列，
   对身高相同的人，按体重由轻到重排列，
   对于身高体重都相同的人，维持原有的编号顺序关系。
   请输出排列后的学生编号
   输入描述：
      两个序列，每个序列由N个正整数组成，(0<n<=100)。
      第一个序列中的数值代表身高，第二个序列中的数值代表体重，
   输出描述：
      排列结果，每个数据都是原始序列中的学生编号，编号从1开始，
   实例一：
      输入:
       4
       100 100 120 130
       40 30 60 50
      输出:
       2134
   */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] h = getData(size, sc);
        int[] w = getData(size, sc);
        List<Stu> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new Stu(i + 1, h[i], w[i]));
        }
        list.stream().sorted().forEach(e -> {
            System.out.print(e.id);
        });
    }

    public static int[] getData(int size, Scanner scanner) {

        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = scanner.nextInt();
        }
        return data;
    }

}

class Stu implements Comparable<Stu> {
    int id;
    int hight;
    int weigth;

    public Stu(int id, int hight, int weigth) {
        this.id = id;
        this.hight = hight;
        this.weigth = weigth;
    }

    @Override
    public int compareTo(Stu o) {
        int ret;
        if ((ret = this.hight - o.hight) == 0) {
            ret = this.weigth - o.weigth;
        }
        if (ret == 0) {
            ret = this.id - o.id;
        }
        return ret;
    }
}