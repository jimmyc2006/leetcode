package shuwei.leetcode.cn.seven.three.nine;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        // 1, 1, 4, 2, 1, 1, 0, 0
        Assert.assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        // [8,1,5,4,3,2,1,1,0,0]
//        Assert.assertArrayEquals(new int[]{8,1,5,4,3,2,1,1,0,0}, s.dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}));
    }
}
