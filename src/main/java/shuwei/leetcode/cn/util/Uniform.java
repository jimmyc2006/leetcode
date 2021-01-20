package shuwei.leetcode.cn.util;

import java.util.stream.IntStream;

public class Uniform {
    private int[] id;
    private int[] sz;
    private int count;

    public Uniform(int N) {
        count = N;
        id = IntStream.range(0, N).toArray();
        sz = IntStream.range(0, N).toArray();
    }

    public int count() {
        return count;
    }

    public void union(int from, int to) {
        int i = find(from);
        int j = find(to);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public int find(int p) {
        int curr = p;
        while (curr != id[curr]) {
            curr = id[curr];
        }
        id[p] = curr;
        return curr;
    }

    public boolean isConnected(int p1, int p2) {
        return find(p1) == find(p2);
    }
}
