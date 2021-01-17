package shuwei.leetcode.cn.eight.zero.three;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.TestUtil;

public class SolutionTest {

  @Test
  public void test() {
    long start = System.currentTimeMillis();
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[]{2}, s.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}}, new int[][]{{1, 0}}));
    Assert.assertArrayEquals(new int[]{0, 3, 0}, s.hitBricks(new int[][]{{1, 0, 1}, {1, 1, 1}}, new int[][]{{0, 0}, {0, 2}, {1, 1}}));
    int[][] p1 = TestUtil.readTwoArrayFromFile("1.json");
    int[][] p2 = TestUtil.readTwoArrayFromFile("2.json");
    int[] res = TestUtil.readArrayFromFile("3.json");
    s.hitBricks(p1, p2);
//    Assert.assertArrayEquals(res, s.hitBricks(p1, p2));
    Assert.assertArrayEquals(new int[]{0, 2, 0, 0, 0, 0, 2}, s.hitBricks(new int[][]{{1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1, 1},
                    {1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}},
            new int[][]{{4, 6}, {3, 0}, {2, 3}, {2, 6}, {4, 1}, {5, 2}, {2, 1}}));
    Assert.assertArrayEquals(new int[]{0}, s.hitBricks(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 1, 1}}, new int[][]{{1, 1}}));
    Assert.assertArrayEquals(new int[]{0, 0}, s.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 0}}, new int[][]{{1, 1}, {1, 0}}));
    System.out.println(System.currentTimeMillis() - start);
  }
}
