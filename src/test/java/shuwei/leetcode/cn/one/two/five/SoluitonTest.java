package shuwei.leetcode.cn.one.two.five;

import org.junit.Assert;
import org.junit.Test;

public class SoluitonTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertEquals(false, s.isPalindrome("race a car"));
        Assert.assertEquals(true, s.isPalindrome(",."));
        Assert.assertEquals(false, s.isPalindrome("0P"));
    }
}
