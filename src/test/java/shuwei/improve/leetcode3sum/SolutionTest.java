package shuwei.improve.leetcode3sum;
import java.util.List;

import org.junit.Test;

import shuwei.improve.leetcode3sum.Solution;

/**
 * @author shuwei
 * @version 创建时间：2017年8月23日 下午2:29:00
 * 类说明
 */
public class SolutionTest {
    @Test
    public void testThreeSum() {
        Solution s = new Solution();
        List<List<Integer>> result = s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }
}
