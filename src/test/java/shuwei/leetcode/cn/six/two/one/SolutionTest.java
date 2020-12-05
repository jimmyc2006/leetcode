package shuwei.leetcode.cn.six.two.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(7 , s.leastInterval(new char[]{'A','B','C','D','A','B','V'}, 3));
        Assert.assertEquals(12 , s.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 1));
        Assert.assertEquals(19 , s.leastInterval(new char[]{'A','A','A','A','B','B','B','B','C','C','C','C','D','D','D','D','E','F'}, 4));
        Assert.assertEquals(104 , s.leastInterval(new char[]{'A','A','A','B','B','B'}, 50));
        Assert.assertEquals(16, s.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
        Assert.assertEquals(8, s.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        Assert.assertEquals(6, s.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
    }
}
