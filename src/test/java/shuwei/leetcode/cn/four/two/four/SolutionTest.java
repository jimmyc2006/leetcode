package shuwei.leetcode.cn.four.two.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(7, s.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    Assert.assertEquals(4, s.characterReplacement("ABBB", 2));
    Assert.assertEquals(5, s.characterReplacement("BAAAB", 2));
    Assert.assertEquals(2, s.characterReplacement("AABA", 0));
    Assert.assertEquals(4, s.characterReplacement("AABABBA", 1));
    Assert.assertEquals(4, s.characterReplacement("ABAB", 2));
  }
}
