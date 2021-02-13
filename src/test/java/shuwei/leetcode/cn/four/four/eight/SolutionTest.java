package shuwei.leetcode.cn.four.four.eight;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        System.out.println(s.findDisappearedNumbers(new int[]{2, 1}));
        System.out.println(s.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(s.findDisappearedNumbers(new int[]{2, 2}));
        System.out.println(s.findDisappearedNumbers(new int[]{4, 4, 4, 4, 4, 4, 3, 1}));
    }
}
