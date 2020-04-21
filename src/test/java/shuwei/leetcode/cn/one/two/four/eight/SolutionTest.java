package shuwei.leetcode.cn.one.two.four.eight;
/**
 * @author shuwei
 * @version 创建时间：2020年4月21日 下午3:52:33 类说明
 */

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
     Assert.assertEquals(2, s.numberOfSubarrays(new int[] {1, 1, 2, 1, 1}, 3));
     Assert.assertEquals(0, s.numberOfSubarrays(new int[] {2, 4, 6}, 1));
     Assert.assertEquals(16, s.numberOfSubarrays(new int[] {2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
     Assert.assertEquals(3, s.numberOfSubarrays(new int[] {2044, 96397, 50143}, 1));
     Assert.assertEquals(6, s.numberOfSubarrays(new int[] {91473, 45388, 24720, 35841, 29648,
     77363,
     86290, 58032, 53752, 87188, 34428, 85343, 19801, 73201}, 4));
    Assert.assertEquals(28, s.numberOfSubarrays(new int[] {45627, 50891, 94884, 11286, 35337, 46414,
        62029, 20247, 72789, 89158, 54203, 79628, 25920, 16832, 47469, 80909}, 1));
  }
}
