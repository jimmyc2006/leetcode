package shuwei.leetcode.cn.eight.six;

import org.junit.Assert;
import org.junit.Test;
import shuwei.leetcode.cn.ListNode;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        ListNode partition = s.partition(ListNode.gen("[1,4,3,2,5,2]"), 3);
        Assert.assertEquals("1,2,2,4,3,5", partition.b2String());
        ListNode partition2 = s.partition(ListNode.gen("[1]"), 3);
        Assert.assertEquals("1", partition2.b2String());
        ListNode partition3 = s.partition(null, 3);
        Assert.assertEquals(null, partition3);
    }
}
