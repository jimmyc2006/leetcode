package shuwei.leetcode.cn.eight.three.nine;

public class Solution {
  public int numSimilarGroups(String[] strs) {
    int length = strs.length;
    DisjointSet uniform = new DisjointSet(length);
    for (int i = 0; i < length; i++) {
      String str1 = strs[i];
      for (int j =  i + 1; j < length; j++) {
        if (uniform.find(i) != uniform.find(j) && isLike(str1, strs[j])) {
          uniform.union(i, j);
        }
      }
    }
    return uniform.size();
  }

  private boolean isLike(String str1, String str2) {
    for (int i = 0, cnt = 0, len = str1.length(); i < len; i++) {
      if (str1.charAt(i) == str2.charAt(i)) continue;
      if (++cnt == 3) return false;
    }
    return true;
  }
}
class DisjointSet {
  private final int[] parent;
  private int size;

  public DisjointSet(int size) {
    parent = new int[this.size = size];
    while (--size > 0) parent[size] = size;
  }

  public int find(int i) {
    if (parent[i] == i) return i;
    return parent[i] = find(parent[i]);
  }

  public void union(int i, int j) {
    int p1 = find(i), p2 = find(j);
    if (p1 == p2) return;
    parent[p1] = p2;
    --size;
  }

  public int size() {
    return size;
  }
}