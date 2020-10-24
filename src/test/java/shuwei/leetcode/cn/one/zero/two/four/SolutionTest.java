package shuwei.leetcode.cn.one.zero.two.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(1, s.videoStitching(new int[][]{{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}}, 5));
    Assert.assertEquals(3, s.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
    Assert.assertEquals(-1, s.videoStitching(new int[][]{{0, 1}, {1, 2}}, 5));
    Assert.assertEquals(3, s.videoStitching(new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}
    }, 9));
    Assert.assertEquals(2, s.videoStitching(new int[][]{{0,4},{2,8}}, 5));
    Assert.assertEquals(1, s.videoStitching(new int[][]{{0,4}}, 1));
    Assert.assertEquals(-1, s.videoStitching(new int[][]{{0,4}}, 9));
  }
}
