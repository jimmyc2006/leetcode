package shuwei.leetcode.cn.two.one.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
//        Assert.assertEquals(5, s.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
//        Assert.assertEquals(4, s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
//        Assert.assertEquals(-1, s.findKthLargest(new int[]{-1, -1}, 2));
//        Assert.assertEquals(99, s.findKthLargest(new int[]{99, 99}, 1));
        Assert.assertEquals(3, s.findKthLargest(new int[]{7,6,5,4,3,2,1}, 5));
    }
}
