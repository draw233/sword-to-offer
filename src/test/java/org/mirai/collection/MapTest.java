package org.mirai.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mirau on 2022/3/1.
 * @version 1.0
 */
public class MapTest {
    Map<String, List<Integer>> map = new HashMap<>();

    @Test
    public void testPutAbsent() {
        List<Integer> aa = map.putIfAbsent("aa", new ArrayList<>());
        Assert.assertNull(aa);
    }

    @Test
    public void testGetOrDefault() {
        List<Integer> aa = map.getOrDefault("aa", new ArrayList<>());
        Assert.assertEquals(aa.size(), 0);
        aa.add(101);
        map.putIfAbsent("aa", aa);
        List<Integer> aa1 = map.getOrDefault("aa", new ArrayList<>());
        Assert.assertEquals(aa1.size(), 1);

    }
}
