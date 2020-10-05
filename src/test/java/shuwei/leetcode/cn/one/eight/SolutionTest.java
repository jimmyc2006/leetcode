package shuwei.leetcode.cn.one.eight;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void test(){
        Solution s = new Solution();
        List<List<Integer>> lists = s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> ele : lists){
            System.out.println(ele);
        }
    }

    @Test
    public void test2(){
        Solution s = new Solution();
        List<List<Integer>> lists = s.fourSum(new int[]{-1,0,1,2,-1,-4}, -1);
        // [[-4,0,1,2],[-1,-1,0,1]]
        for (List<Integer> ele : lists){
            System.out.println(ele);
        }
    }

    @Test
    public void test1(){
        Solution s = new Solution();
        long start = System.currentTimeMillis();
        List<List<Integer>> lists = s.fourSum(new int[]{-444,-400,-398,-387,-372,-347,-340,-337,-330,-326,-326,-308,-304,-295,-270,-228,-224,-213,-196,-192,-186,-118,-103,-92,-89,-42,-31,-28,-20,-19,-8,1,1,9,48,49,74,88,90,135,152,160,170,181,181,202,238,254,271,272,274,285,287,302,314,319,342,373,373,392,400,453,482},
                -4402);
        System.out.println(System.currentTimeMillis() - start);
        for (List<Integer> ele : lists){
            System.out.println(ele);
        }
    }
}
