package shuwei.leetcode.cn;

public class Uniform {
  private int[] points;
  private int group;

  public Uniform(int N) {
    group = N;
    points = new int[N];
    for (int i = 0; i < N; i++) {
      points[i] = i;
    }
  }

  public boolean isConnection(int p1, int p2) {
    return find(p1) == find(p2);
  }

  public int find(int point) {
    if (point != points[point]) {
      points[point] = find(points[point]);
    }
    return points[point];
  }

  public void union(int p1, int p2) {
    int p1f = find(p1);
    int p2f = find(p2);
    if (p1f == p2f) {
      return;
    }
    points[p1f] = p2f;
    group--;
  }

  public int getGroup() {
    return group;
  }
}
