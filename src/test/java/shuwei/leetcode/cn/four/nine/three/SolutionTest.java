package shuwei.leetcode.cn.four.nine.three;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(625284395, s.reversePairs(testData()));
//    Assert.assertEquals(1, s.reversePairs(new int[]{3, 1}));
//    Assert.assertEquals(2, s.reversePairs(new int[]{1, 3, 2, 3, 1}));
//    Assert.assertEquals(3, s.reversePairs(new int[]{2, 4, 3, 5, 1}));
  }

  private int[] testData() {
    try {
      String str = FileUtils.readLines(new File("/Users/shuwei/Downloads/data1128")).get(0);
      String[] split = str.split(",");
      int[] res = new int[split.length];
      for (int i = 0; i < res.length; i++) {
        res[i] = Integer.parseInt(split[i]);
      }
      System.out.println(res.length);
      return res;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Test
  public void testCal() {
    Solution s = new Solution();
    s.cal(new int[]{-390, -322, -300, -219, -148, -125, -119, -92, -83, -82, -81, -76, -43, -24, -3, 3, 102, 144, 155, 192, 236, 251, 413, 477},
            new int[]{-477, -415, -388, -254, -227, -179, -173, -152, -109, -102, -83, -73, -71, -53, -27, -19, 3, 8, 34, 54, 57, 127, 283, 301});
  }
}
