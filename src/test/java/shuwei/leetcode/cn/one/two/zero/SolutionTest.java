package shuwei.leetcode.cn.one.two.zero;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        List<List<Integer>> data = new ArrayList<>();
        data.add(Arrays.asList(2));
        data.add(Arrays.asList(3, 4));
        data.add(Arrays.asList(6,5,7));
        data.add(Arrays.asList(4,1,8,3));
        Assert.assertEquals(11, s.minimumTotal(data));
    }
}
