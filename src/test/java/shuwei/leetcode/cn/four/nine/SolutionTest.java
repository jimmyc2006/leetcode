package shuwei.leetcode.cn.four.nine;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        List<List<String>> lists = s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> ele : lists) {
            System.out.println(ele);
        }
        lists = s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        print(lists);
    }

    private void print(List<List<String>> data) {
        for (List<String> ele : data) {
            System.out.println(ele);
        }
    }
}
