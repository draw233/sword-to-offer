package org.mirai.hj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class HJ68 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> allList = new ArrayList<>();
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            int order = sc.nextInt();
            List<Person> list = new ArrayList<>();

            while (nums-- > 0) {
                list.add(new Person(sc.next(), sc.nextInt()));
            }
            list.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    if (order == 1) {
                        return o1.score - o2.score;
                    } else {
                        return o2.score - o1.score;
                    }
                }
            });
            allList.addAll(list);
        }
        for (Person person : allList) {
            System.out.println(person.name + " " + person.score);
        }
    }
}

class Person {
    String name;
    int score;

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

}
