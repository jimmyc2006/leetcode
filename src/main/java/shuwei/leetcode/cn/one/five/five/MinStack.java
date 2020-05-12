package shuwei.leetcode.cn.one.five.five;

import java.util.Stack;

public class MinStack {
  
  private Stack<Integer> contentStack;
  private Stack<Integer> minStack;
  
  public MinStack() {
    contentStack = new Stack<>();
    minStack = new Stack<>();
    minStack.push(Integer.MAX_VALUE);
  }

  public void push(int x) {
    contentStack.push(x);
    int lastMin = minStack.peek();
    if (x < lastMin) {
      minStack.push(x);
    } else {
      minStack.push(lastMin);
    }
  }

  public void pop() {
    contentStack.pop();
    minStack.pop();
  }

  public int top() {
    return contentStack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
