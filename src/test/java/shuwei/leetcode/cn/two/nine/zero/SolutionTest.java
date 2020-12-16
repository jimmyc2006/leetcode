package shuwei.leetcode.cn.two.nine.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.wordPattern("", ""));
        Assert.assertEquals(false, s.wordPattern("aaaa", "dog cat cat dog"));
        Assert.assertEquals(true, s.wordPattern("abba", "dog cat cat dog"));
        Assert.assertEquals(false, s.wordPattern("abba", "dog cat cat fish"));
        Assert.assertEquals(false, s.wordPattern("abba", "dog dog dog dog"));
    }
}
