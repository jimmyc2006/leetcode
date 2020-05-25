package shuwei.improve.accu.string;

import org.junit.Assert;
import org.junit.Test;

public class KmpTest {
  @Test
  public void testPatternIndex() {
    Kmp kmp = new Kmp();
    Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 1, 2, 3, 1}, kmp.genPatternIndex("abcdabca"));
    Assert.assertArrayEquals(new int[]{0, 1, 0, 1, 2, 3, 4, 5, 2}, kmp.genPatternIndex("aabaabaaa"));
    Assert.assertArrayEquals(new int[]{0, 0, 0, 1, 2, 0}, kmp.genPatternIndex("abcaby"));
  }

  @Test
  public void testKmpMatch() {
    Kmp kmp = new Kmp();
    Assert.assertEquals(1, kmp.kmpMatch("babceee", "abc"));
    Assert.assertEquals(2, kmp.kmpMatch("babceabcee", "bc"));
    Assert.assertEquals(6, kmp.kmpMatch("abxabcabcaby", "abcaby"));
  }
}
