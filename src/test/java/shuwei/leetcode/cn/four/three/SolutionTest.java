package shuwei.leetcode.cn.four.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        System.out.println(s.multiply("123456789", "987654321"));
        Assert.assertEquals("0", s.multiply("0", "52"));
        Assert.assertEquals("0", s.multiply("789", "0"));
        Assert.assertEquals("6", s.multiply("2", "3"));
        Assert.assertEquals("56088", s.multiply("123", "456"));
        Assert.assertEquals("175158", s.multiply("789", "222"));

    }

}
