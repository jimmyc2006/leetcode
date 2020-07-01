package shuwei.leetcode.cn.mst.zero.nine;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {

  private Deque<Integer> inStack;
  private Deque<Integer> outStack;

  public CQueue() {
    inStack = new ArrayDeque<>();
    outStack = new ArrayDeque<>();
  }

  public void appendTail(int value) {
    inStack.push(value);
  }

  public int deleteHead() {
    if (outStack.isEmpty()) {
      if (inStack.isEmpty()) {
        return -1;
      } else {
        while(!inStack.isEmpty()) {
          outStack.push(inStack.poll());
        }
        return outStack.poll();
      }
    } else {
      return outStack.poll();
    }
  }
}
