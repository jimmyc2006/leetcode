package shuwei.leetcode.cn.one.five.eight.four;

import java.util.LinkedList;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    List<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    for (Integer in : list) {
      System.out.println(in);
      list.remove(in);
    }
  }
}
