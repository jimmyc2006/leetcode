package shuwei.leetcode.cn.one.six.four;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    int[] td = new int[] {
            15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740
    };
    Arrays.sort(td);
    Assert.assertEquals(2901, s.maximumGap(td));
    Assert.assertEquals(1, s.maximumGap(new int[]{1, 1, 1, 2}));
    Assert.assertEquals(0, s.maximumGap(new int[]{1, 1, 1, 1}));
    Assert.assertEquals(3, s.maximumGap(new int[]{3, 6, 9, 1}));
  }
}
