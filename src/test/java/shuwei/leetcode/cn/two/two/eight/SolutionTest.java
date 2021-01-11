package shuwei.leetcode.cn.two.two.eight;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        List<String> strings = s.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println(strings);
        System.out.println(s.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(s.summaryRanges(new int[]{}));
        System.out.println(s.summaryRanges(new int[]{-1}));
        System.out.println(s.summaryRanges(new int[]{0}));
    }
}
