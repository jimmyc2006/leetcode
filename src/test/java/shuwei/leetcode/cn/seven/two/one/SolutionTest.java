package shuwei.leetcode.cn.seven.two.one;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionTest {

  @Test
  public void test2() {
    PriorityQueue<String> pq = new PriorityQueue<>();
    pq.add("johnsmith@mail.com");
//    pq.add("")
    System.out.println("johnsmith@mail.com".compareTo("john_newyork@mail.com"));
  }

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.accountsMerge(Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com"), Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("Mary", "mary@mail.com"))));
  }
}
