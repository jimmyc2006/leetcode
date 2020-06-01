package shuwei.leetcode.cn.three.nine.four;


import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("aaabcbc", s.decodeString("3[a]2[bc]"));
        Assert.assertEquals("abcabccdcdcdef", s.decodeString("2[abc]3[cd]ef"));
        Assert.assertEquals("accaccacc", s.decodeString("3[a2[c]]"));
    }
}
