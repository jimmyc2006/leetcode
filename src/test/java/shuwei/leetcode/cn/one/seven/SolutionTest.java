package shuwei.leetcode.cn.one.seven;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<String> res = s.letterCombinations("23");
    System.out.println(res);
    List<String> res2 = s.letterCombinations("2");
    System.out.println(res2);
    List<String> res3 = s.letterCombinations("");
    System.out.println(res3);
  }

}
