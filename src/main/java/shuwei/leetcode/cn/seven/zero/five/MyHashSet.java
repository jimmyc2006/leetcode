package shuwei.leetcode.cn.seven.zero.five;

public class MyHashSet {

  private boolean[] data;
  /** Initialize your data structure here. */
  public MyHashSet() {
    data = new boolean[1000000 + 1];
  }

  public void add(int key) {
    data[key] = true;
  }

  public void remove(int key) {
    data[key] = false;
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    return data[key];
  }
}
