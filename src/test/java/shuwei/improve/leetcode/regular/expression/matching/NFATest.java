package shuwei.improve.leetcode.regular.expression.matching;
import org.junit.Assert;
import org.junit.Test;

import shuwei.improve.leetcode.regular.expression.matching.NFA;

/**
 * @author shuwei
 * @version 创建时间：2017年8月31日 下午8:39:54
 * 类说明
 */
public class NFATest {
    @Test
    public void testRegex() {
        Assert.assertTrue(!test("aa","a"));
        Assert.assertTrue(test("aa","aa"));
        Assert.assertTrue(!test("aaa","aa"));
        Assert.assertTrue(test("aa", "a*"));
        Assert.assertTrue(test("aa", ".*"));
        Assert.assertTrue(test("ab", ".*"));
        Assert.assertTrue(test("aab", "c*a*b"));
        Assert.assertTrue(!test("ab", ".*c"));
        Assert.assertTrue(test("aaca", "ab*a*c*a"));
        Assert.assertTrue(test("aaa", "ab*a*c*a"));
        Assert.assertTrue(!test("aaba", "ab*a*c*a"));
        Assert.assertTrue(!test("bbab", "b*a*"));
        Assert.assertTrue(test("a", "ab*"));
        Assert.assertTrue(test("bbbba", ".*a*a"));
        Assert.assertTrue(test("ab", ".*.."));
    }
    private boolean test(String txt , String regex) {
        NFA nfa = new NFA(regex);
        return nfa.recognizes(txt);
    }
}
