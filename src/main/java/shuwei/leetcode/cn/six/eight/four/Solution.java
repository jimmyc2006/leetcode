package shuwei.leetcode.cn.six.eight.four;

public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        Uniform uniform = new Uniform(length +1);
        for (int[] ele : edges) {
            if (uniform.isConnected(ele[0], ele[1])) {
                return ele;
            } else {
                uniform.union(ele[0], ele[1]);
            }
        }
        return null;
    }
}
class Uniform {

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
/*
public int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
 */