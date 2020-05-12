package shuwei.leetcode.cn.one.five.five;

import java.util.Stack;
import java.util.TreeMap;

public class MinStack1 {
  TreeMap<Integer, Integer> treeMap;
  Stack<Integer> stack;
  
  public MinStack1() {
    treeMap = new TreeMap<>();
    stack = new Stack<>();
  }
  
  public void push(int x) {
    stack.add(x);
    Integer times = treeMap.get(x);
    if (times == null) {
      treeMap.put(x, 1);
    } else {
      treeMap.put(x, times + 1);
    }
  }
  
  public void pop() {
    Integer i = stack.pop();
    Integer times = treeMap.get(i);
    if (times > 1) {
      treeMap.put(i, times - 1);
    } else {
      treeMap.remove(i);
    }
  }
  
  public int top() {
    return stack.peek();
  }
  
  public int getMin() {
    return treeMap.firstKey();
  }
}
