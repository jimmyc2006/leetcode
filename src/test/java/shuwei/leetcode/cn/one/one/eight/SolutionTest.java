package shuwei.leetcode.cn.one.one.eight;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        List<List<Integer>> res = s.generate(5);
        for (List<Integer> ele : res) {
            System.out.println(ele);
        }
    }
}
