package shuwei.leetcode.cn.one.zero.zero.two;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    List<String> strings = s.commonChars(new String[]{"bella", "label", "roller"});
    for (String ele : strings) {
      System.out.println(ele);
    }
  }

  @Test
  public void test1() {
    Solution s = new Solution();
    List<String> strings = s.commonChars(new String[]{"cool","lock","cook"});
    for (String ele : strings) {
      System.out.println(ele);
    }
  }
}
