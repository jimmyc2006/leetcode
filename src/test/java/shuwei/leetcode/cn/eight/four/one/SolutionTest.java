package shuwei.leetcode.cn.eight.four.one;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    List<List<Integer>> param = new ArrayList<>();
    param.add(Arrays.asList(1));
    param.add(Arrays.asList(2));
    param.add(Arrays.asList(3));
    param.add(Arrays.asList());
    Assert.assertEquals(true, s.canVisitAllRooms(param));


    List<List<Integer>> param2 = new ArrayList<>();
    param2.add(Arrays.asList(1, 3));
    param2.add(Arrays.asList(3, 0, 1));
    param2.add(Arrays.asList(2));
    param2.add(Arrays.asList(0));
    Assert.assertEquals(false, s.canVisitAllRooms(param2));

    System.out.println(s.canVisitAllRooms(new ArrayList<>()));

    List<List<Integer>> param3 = new ArrayList<>();
    param3.add(Arrays.asList());
    System.out.println(s.canVisitAllRooms(param3));
  }
}
