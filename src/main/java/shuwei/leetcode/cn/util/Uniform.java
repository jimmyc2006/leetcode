package shuwei.leetcode.cn.util;

public class Uniform {

    private int[] id;

    public Uniform(int N) {
        id = new int[N];
        for (int i = 0 ; i < N; i++) {
            id[i] = i;
        }
    }

    public void union(int from, int to) {
        int i = find(from);
        int j = find(to);
        if (i == j) {
            return;
        }
        id[i] = j;
    }

    public int find(int p) {
        if(p != id[p]) {
            id[p] = find(id[p]);
        }
        return id[p];
    }

    public boolean isConnected(int p1, int p2) {
        return find(p1) == find(p2);
    }
}
