package shuwei.leetcode.cn.one.four.zero;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<String> strings = s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
    System.out.println(strings);
  }

  @Test
  public void test1() {
    Solution s = new Solution();
    List<String> strings = s.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
    System.out.println(strings);
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    List<String> strings = s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
    System.out.println(strings);
  }

  @Test
  public void test3() {
    Solution s = new Solution();
    List<String> strings = s.wordBreak("a", Arrays.asList("a"));
    System.out.println(strings);
  }

  @Test
  public void test4() {
    Solution s = new Solution();
    List<String> strings = s.wordBreak("ab", Arrays.asList("a", "b"));
    System.out.println(strings);
  }

}
