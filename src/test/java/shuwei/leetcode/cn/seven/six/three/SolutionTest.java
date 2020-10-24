package shuwei.leetcode.cn.seven.six.three;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<Integer> res = s.partitionLabels("ababcbacadefegdehijhklij");
    Assert.assertEquals("[9, 7, 8]", res.toString());
    System.out.println(s.partitionLabels("a"));
  }

}
