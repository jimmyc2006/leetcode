package shuwei.improve.leetcode.myAtoi;
import org.junit.Assert;
import org.junit.Test;

import shuwei.improve.leetcode.myAtoi.Solution;

/**
 * @author shuwei
 * @version 创建时间：2017年8月28日 下午5:40:16
 * 类说明
 */
public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(-11, s.myAtoi("  -11"));
        Assert.assertEquals(1123455, s.myAtoi("  1123455wefwefswf"));
        Assert.assertEquals(Integer.MIN_VALUE, s.myAtoi("  -1123455999999999999wefwefswf"));
        Assert.assertEquals(Integer.MAX_VALUE, s.myAtoi("  1123455999999999999wefwefswf"));
        Assert.assertEquals(0, s.myAtoi("  a1123455999999999999wefwefswf"));
        Assert.assertEquals(0, s.myAtoi("  "));
        Assert.assertEquals(2147483647, s.myAtoi("2147483647"));
        Assert.assertEquals(2147483647, s.myAtoi("2147483648"));
        Assert.assertEquals(-2147483648, s.myAtoi("-2147483648"));
        Assert.assertEquals(-2147483648, s.myAtoi("-2147483649"));
        Assert.assertEquals(1, s.myAtoi("  1"));
        Assert.assertEquals(0, s.myAtoi("  -"));
        Assert.assertEquals(1, s.myAtoi("1"));
        Assert.assertEquals(0, s.myAtoi("+"));
    }
}
