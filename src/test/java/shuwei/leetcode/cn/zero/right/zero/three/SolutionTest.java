package shuwei.leetcode.cn.zero.right.zero.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(0, s.findMagicIndex(new int[]{0, 2, 3, 4, 5}));
    Assert.assertEquals(1, s.findMagicIndex(new int[]{1, 1, 1}));
    Assert.assertEquals(22, s.findMagicIndex(new int[]{-531369933, -469065528, -430059048, -428981853, -319235969, -288076332, -286667432, -282312559, -197049680, -197022263, -174416117, -138027773, -121899023, -111631966, -107567458, -70437707, -52463072, -45519851, -38641451, -15825815, -3835472, -1525043, 22, 566842886, 593757472, 605439236, 619794079, 640069993, 657657758, 718772950, 815849552, 839357142, 936585256, 1006188278, 1042347147, 1057129320, 1062178586, 1069769438}));
  }
}
