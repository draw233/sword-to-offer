package org.mirai.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class ListTest {

    @Test
    public void testSkip() {
        Stream.of(1, 5, 6).skip(3).forEach(System.out::println);
    }

    @Test
    public void testSub() {
        int sum = Stream.of(1, 2, 3, 4, 5).mapToInt(e -> e).sum();
        System.out.println(sum);
    }

    @Test
    public void testI() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 5));
        // 取集合前3个值，且每个元素都大于2
        Set<Integer> collect = list.subList(0, 3).stream().filter(e -> e > 2).collect(Collectors.toSet());
        System.out.println(collect.size());
    }
}
