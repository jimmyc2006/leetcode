package shuwei.leetcode.cn.three.three.two;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    List<List<String>> data = new ArrayList<>();
    data.add(Arrays.asList("MUC", "LHR"));
    data.add(Arrays.asList("JFK", "MUC"));
    data.add(Arrays.asList("SFO", "SJC"));
    data.add(Arrays.asList("LHR", "SFO"));
    List<String> itinerary = s.findItinerary(data);
    System.out.println(itinerary);
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    List<List<String>> data = new ArrayList<>();
    data.add(Arrays.asList("JFK","SFO"));
    data.add(Arrays.asList("JFK","ATL"));
    data.add(Arrays.asList("SFO","ATL"));
    data.add(Arrays.asList("ATL","JFK"));
    data.add(Arrays.asList("ATL","SFO"));
    List<String> itinerary = s.findItinerary(data);
    System.out.println(itinerary);
  }

  @Test
  public void test3() {
    Solution s = new Solution();
    List<List<String>> data = new ArrayList<>();
    data.add(Arrays.asList("JFK","KUL"));
    data.add(Arrays.asList("JFK","NRT"));
    data.add(Arrays.asList("NRT","JFK"));
    List<String> itinerary = s.findItinerary(data);
    System.out.println(itinerary);
  }
}
