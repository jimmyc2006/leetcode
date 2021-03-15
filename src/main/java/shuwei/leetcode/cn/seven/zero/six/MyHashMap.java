package shuwei.leetcode.cn.seven.zero.six;

import java.util.Arrays;

public class MyHashMap {

  private int[] data;

  /** Initialize your data structure here. */
  public MyHashMap() {
    data = new int[1000000 + 1];
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    data[key] = value + 1;
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
    return data[key] - 1;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    data[key] = 0;
  }
}
