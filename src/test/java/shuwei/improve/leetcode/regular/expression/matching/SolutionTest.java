package shuwei.improve.leetcode.regular.expression.matching;
import org.junit.Assert;
import org.junit.Test;

import shuwei.improve.leetcode.regular.expression.matching.Solution;

/**
 * @author shuwei
 * @version 创建时间：2017年8月29日 下午8:28:09
 * 类说明
 */
public class SolutionTest {
    
    @Test
    public void testIsMatch() {
        Solution s = new Solution();
        Assert.assertTrue(!s.isMatch("aa","a"));
        Assert.assertTrue(s.isMatch("aa","aa"));
        Assert.assertTrue(!s.isMatch("aaa","aa"));
        Assert.assertTrue(s.isMatch("aa", "a*"));
        Assert.assertTrue(s.isMatch("aa", ".*"));
        Assert.assertTrue(s.isMatch("ab", ".*"));
        Assert.assertTrue(s.isMatch("aab", "c*a*b"));
        Assert.assertTrue(!s.isMatch("ab", ".*c"));
        Assert.assertTrue(s.isMatch("aaca", "ab*a*c*a"));
        Assert.assertTrue(s.isMatch("aaa", "ab*a*c*a"));
        Assert.assertTrue(!s.isMatch("aaba", "ab*a*c*a"));
        Assert.assertTrue(!s.isMatch("bbab", "b*a*"));
        Assert.assertTrue(s.isMatch("a", "ab*"));
        Assert.assertTrue(s.isMatch("bbbba", ".*a*a"));
        Assert.assertTrue(s.isMatch("ab", ".*.."));
    }
}