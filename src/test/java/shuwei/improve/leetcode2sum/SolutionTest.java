package shuwei.improve.leetcode2sum;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import shuwei.improve.leetcode2sum.Solution;
/**
 * @author shuwei
 * @version 创建时间：2017年8月23日 下午1:37:31
 * 类说明
 */
public class SolutionTest {
    
    @Test
    public void testTwoSum () {
        Solution s = new Solution();
        int[] res = s.twoSum(new int[]{1, 2, 3, 4}, 3);
        Assert.assertTrue(Arrays.equals(new int[]{0, 1}, res));
        int[] res2 = s.twoSum(new int[]{4, 2, 3, 1}, 3);
        Assert.assertTrue(Arrays.equals(new int[]{1, 3}, res2));
        int[] res3 = s.twoSum(new int[]{4, 2, 3, 1}, 6);
        Assert.assertTrue(Arrays.equals(new int[]{0, 1}, res3));
        int[] res4 = s.twoSum(new int[]{4, 2, 3, 1}, 9);
        Assert.assertNull(res4);
        int[] res5 = s.twoSum(new int[]{4, 2, 3, 1}, 1);
        Assert.assertNull(res5);
        int[] res6 = s.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertTrue(Arrays.equals(new int[]{0, 1}, res6));
        // 没通过的检查用例
        int[] res7= s.twoSum(new int[]{0,4,3,0}, 0);
        Assert.assertTrue(Arrays.equals(new int[]{0, 3}, res7));
        int[] res8= s.twoSum(new int[]{-1, -2, -3, -4, -5}, -8);
        Assert.assertTrue(Arrays.equals(new int[]{2, 4}, res8));
    }
}