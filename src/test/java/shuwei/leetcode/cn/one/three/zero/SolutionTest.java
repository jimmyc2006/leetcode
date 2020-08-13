package shuwei.leetcode.cn.one.three.zero;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        char[][] t = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        s.solve(t);
        for (char[] ele : t){
            System.out.println(Arrays.toString(ele));
        }
        s.solve(new char[][]{{}});
    }
}
