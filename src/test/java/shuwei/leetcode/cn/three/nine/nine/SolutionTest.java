package shuwei.leetcode.cn.three.nine.nine;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        //  [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        // 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
        List<List<String>> lists = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> query = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"),
                Arrays.asList("x", "x"));
        double[] ans = s.calcEquation(lists, values, query);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test1() {
        Solution s = new Solution();
        //  输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
        //输出：[3.75000,0.40000,5.00000,0.20000]
        List<List<String>> lists = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("bc", "cd"));
        double[] values = new double[]{1.5, 2.5, 5.0};
        List<List<String>> query = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("c", "b"), Arrays.asList("bc", "cd"), Arrays.asList("cd", "bc"));
        double[] ans = s.calcEquation(lists, values, query);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        //  输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
        //输出：[0.50000,2.00000,-1.00000,-1.00000]
        List<List<String>> lists = Arrays.asList(Arrays.asList("a", "b"));
        double[] values = new double[]{0.5};
        List<List<String>> query = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "a"), Arrays.asList("a", "c"), Arrays.asList("x", "y"));
        double[] ans = s.calcEquation(lists, values, query);
        System.out.println(Arrays.toString(ans));
    }
}
