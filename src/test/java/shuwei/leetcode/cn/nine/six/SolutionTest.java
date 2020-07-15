package shuwei.leetcode.cn.nine.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        // 计算方法
        // 3的时候是两边1和3选定以后，就跟2一样，也就是2 * f[2],然后3除了这2个数还有一个2,2放根的时候，只有1中，所以3个2*2 + 1 = 5; final : 2 * 2 + 1
        // 4，选择两边1和4作为root的时候，其他地方跟3一样，也就是2 * f[3],剩下2和3分别做root的时候一个子节点的固定的，2 * 2 = 4；final: 2 * 5 + 2 * 2
        // 5,选择两边1和5走位root的时候: 2 * f[4],然后还剩下3个2,3,4;2和4的时候2 * f[3],剩下3的时候2 * 2 = 4; final: 2 * 14 + 2 * 5 + 2 * 2;
        Solution s = new Solution();
//        Assert.assertEquals(5, s.numTrees(3));
//        Assert.assertEquals(14, s.numTrees(4));
        Assert.assertEquals(42, s.numTrees(5));
    }
}
