package shuwei.leetcode.cn.seven.five;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void test(){
        Solution s = new Solution();
        int[] data = new int[]{2,0,2,1,1,0};
        s.sortColors(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void test1(){
        Solution s = new Solution();
        int[] data = new int[]{2};
        s.sortColors(data);
        System.out.println(Arrays.toString(data));
    }
}
