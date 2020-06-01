package shuwei.leetcode.cn.one.four.one.three;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test() {
        Solution to = new Solution();
        System.out.println(to.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(to.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
    }
}
