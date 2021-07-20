package shuwei.leetcode.cn.two.three.two;

import java.util.Stack;

public class MyQueue {
  Stack<Integer> in;
  Stack<Integer> out;

  /** Initialize your data structure here. */
  public MyQueue() {
    in = new Stack<>();
    out = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    in.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    dealEmpty();
    return out.pop();
  }

  /** Get the front element. */
  public int peek() {
    dealEmpty();
    return out.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return in.isEmpty() && out.isEmpty();
  }

  private void dealEmpty() {
    if (!out.isEmpty()) {
      return;
    }
    if (!in.isEmpty()) {
      Integer tmp;
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
    return;
  }
}
