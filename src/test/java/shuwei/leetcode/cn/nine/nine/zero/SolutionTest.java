package shuwei.leetcode.cn.nine.nine.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.equationsPossible(new String[]{"b==a", "a==b"}));
    Assert.assertEquals(false, s.equationsPossible(new String[]{"a==b","b!=a"}));
    Assert.assertEquals(true, s.equationsPossible(new String[]{"a==b","b==c","a==c"}));
    Assert.assertEquals(false, s.equationsPossible(new String[]{"a==b","b!=c","c==a"}));
    Assert.assertEquals(true, s.equationsPossible(new String[]{"c==c","b==d","x!=z"}));
    Assert.assertEquals(false, s.equationsPossible(new String[]{"f==a","a==b","f!=e","a==c","b==e","c==f"}));
    Assert.assertEquals(false, s.equationsPossible(new String[]{"a==b","e==c","b==c","a!=e"}));
    Assert.assertEquals(false, s.equationsPossible(new String[]{"q==j", "d!=n", "u==a",
            "o!=e", "e==l", "q==s", "q!=h", "h!=w", "q!=n", "k==q",
            "m==k", "h!=u", "l==i", "b!=d", "a!=x", "c==h", "f!=k",
            "r==u", "o!=r", "n!=t", "p==n", "o!=m", "m!=w", "b!=f",
            "h!=o", "v==v", "j!=b", "k!=n", "w!=a", "i!=x", "o!=q",
            "u!=n", "i!=c", "q!=c", "p!=f", "u!=t", "a==r", "h!=k",
            "y==y", "r==o"}));

  }
}
