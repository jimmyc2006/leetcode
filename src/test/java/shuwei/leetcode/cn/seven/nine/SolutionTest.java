package shuwei.leetcode.cn.seven.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    char[][] letters = new char[][]{
            {
                    'A', 'B', 'C', 'E'
            }, {
            'S', 'F', 'C', 'S'
    }, {
            'A', 'D', 'E', 'E'
    }
    };
    Assert.assertEquals(true, s.exist(new char[][]{{'A'}}, "A"));
    Assert.assertEquals(true, s.exist(letters,
            "ABCCED"));
    Assert.assertEquals(true, s.exist(letters, "SEE"));
    Assert.assertEquals(false, s.exist(letters, "ABCB"));
  }

}
