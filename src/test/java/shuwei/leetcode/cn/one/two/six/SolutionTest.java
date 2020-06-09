package shuwei.leetcode.cn.one.two.six;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    for (List<String> l : s.findLadders("hit", "cog",
            Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))) {
      System.out.println(l);
    }
  }
}
