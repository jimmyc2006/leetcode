package shuwei.leetcode.cn.one.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shuwei
 * @version 创建时间：2020年4月18日 下午7:39:49 类说明
 */
public class SolutionTest {
  @Test
  public void test1() {
    Solution s = new Solution();
    Assert.assertEquals(49, s.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    Assert.assertEquals(25, s.maxArea(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    Assert.assertEquals(2, s.maxArea(new int[] {1, 2, 1}));
    Assert.assertEquals(15252,
        s.maxArea(new int[] {136, 114, 104, 156, 183, 152, 66, 189, 116, 94, 90, 58, 10, 131, 67,
            85, 183, 174, 174, 135, 88, 79, 19, 0, 15, 28, 96, 95, 35, 174, 38, 171, 88, 142, 80,
            24, 95, 146, 13, 163, 192, 103, 21, 154, 187, 40, 40, 122, 167, 166, 58, 7, 46, 77, 7,
            13, 58, 56, 109, 93, 182, 99, 17, 23, 194, 97, 47, 89, 195, 12, 4, 188, 68, 26, 142, 7,
            18, 134, 129, 185, 101, 187, 144, 99, 17, 104, 112, 75, 160, 173, 120, 142, 73, 89, 165,
            67, 138, 164, 108, 134}));
    Assert.assertEquals(17, s.maxArea(new int[] {2, 3, 4, 5, 18, 17, 6}));
    Assert.assertEquals(24, s.maxArea(new int[] {1,3,2,5,25,24,5}));
  }
}
