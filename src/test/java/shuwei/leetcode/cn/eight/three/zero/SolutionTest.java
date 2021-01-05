package shuwei.leetcode.cn.eight.three.zero;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        List<List<Integer>> abbxxxxzzy = s.largeGroupPositions("abbxxxxzzy");
        System.out.println("-----------------1------------");
        for (List<Integer> ele : abbxxxxzzy) {
            System.out.println(ele);
        }
        System.out.println("-------------2---------------");
        List<List<Integer>> res2 = s.largeGroupPositions("abc");
        for (List<Integer> ele : res2) {
            System.out.println(ele);
        }
        System.out.println("-------------3---------------");
        List<List<Integer>> res3 = s.largeGroupPositions("abcdddeeeeaabbbcddd");
        for (List<Integer> ele : res3) {
            System.out.println(ele);
        }
    }
}
