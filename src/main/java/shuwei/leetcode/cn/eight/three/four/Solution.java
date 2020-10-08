package shuwei.leetcode.cn.eight.three.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    int[] ans;
    int[] sz;
    int[] dp;
    List<List<Integer>> graph;

    /**
     * 官方题解
     * @param N
     * @param edges
     * @return
     */
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        sz = new int[N];
        dp = new int[N];
        graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < N; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int u, int f) {
        sz[u] = 1;
        dp[u] = 0;
        for (int v: graph.get(u)) {
            if (v == f) {
                continue;
            }
            dfs(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    public void dfs2(int u, int f) {
        ans[u] = dp[u];
        for (int v: graph.get(u)) {
            if (v == f) {
                continue;
            }
            int pu = dp[u], pv = dp[v];
            int su = sz[u], sv = sz[v];

            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];

            dfs2(v, u);

            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }

    /**
     * 能通过的解法，效率还可
     * 从某一个点开始遍历，2个数组，1个记录分值，一个记录个数
     * 不管多少个分支，只分为入和出
     * @param N
     * @param edges
     * @return
     */
    public int[] sumOfDistancesInTree3(int N, int[][] edges) {
        if (N == 1){
            return new int[]{0};
        }
        this.N = N;
        int[] score = new int[N];
        // count数组不能省略，因为根据某个点的score推导不出来它的count
        int[] count = new int[N];
        List<Integer>[] relations = new List[N];
        // 这种写法用foreach会好一些
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (relations[x] == null){
                relations[x] = new ArrayList<>();
            }
            relations[x].add(y);
            if (relations[y] == null){
                relations[y] = new ArrayList<>();
            }
            relations[y].add(x);
        }
        // 找到一个叶子节点(只有一条线连接)，开始计算
        int start = -1;
        for (int i = 0; i < relations.length; i++) {
            if (relations[i].size() == 1){
                start = i;
                break;
            }
        }
        cal(relations, -1, start, score, count);
        cal2(relations, start, relations[start].get(0), score, count);
        return score;
    }
    private int N;

    /**
     * 每个点的值是 1 + 挨着的点的值 + 它后面的个数
     * 剩下最后一个的时候，只看应该
     * @param relations 关系矩阵
     * @param input 入口数值
     * @param current 当前数值
     * @return 除了入口以外所有出口的值
     */
    private void cal(List<Integer>[] relations, int input, int current, int [] scores, int[] counts) {
        List<Integer> connections = relations[current];
//        connections.remove(input);
        if (connections.size() == 1 && connections.contains(input)){
            scores[current] = 0;
            counts[current] = 0;
            return;
        }
        for (Integer ele : connections) {
            if (ele != input){
                cal(relations, current, ele, scores, counts);
                scores[current] += 1 + scores[ele] + counts[ele];
                counts[current] += 1 +  counts[ele];
            }
        }
    }

    // 入口节点的总数值 = 当前节点总数值 + 1 + 当前节点右边节点的个数 + 其他数值
    // 推导出 当前节点的值 = 入口节点的值 - 当前节点及右边节点的个数
    private void cal2(List<Integer>[] relations, int input, int current, int[] scores, int[] counts){
        scores[current] = scores[input] - 1 - counts[current] + N - 1 - counts[current];
        List<Integer> nexts = relations[current];
        for (Integer ele : nexts){
            if (ele != input){
                cal2(relations, current, ele, scores, counts);
            }
        }
    }

    /**
     * floyd算法,超出内存限制
     * 不过floyd算法代码还是比较优雅
     * @param N
     * @param edges
     * @return
     */
    private int[][] distances;

    public int[] sumOfDistancesInTree2(int N, int[][] edges) {
        distances = new int[N][N];
//        int[][] sequence = new int[N][N];
        for (int i = 0; i < N; i++){
            Arrays.fill(distances[i], N + 1);
            distances[i][i] = 0;
//            Arrays.fill(sequence[i], -1);
        }
        for (int i = 0; i< edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            this.setDistance(x, y, 1);
//            sequence[x][y] = y;
//            sequence[y][x] = x;
        }
        for (int k = 0; k < N; k++){
            for (int i = 0; i < N; i ++) {
                for (int j = 0; j < N; j++){
                    if (distances[i][k] + distances[k][j] < distances[i][j]){
                        distances[i][j] = distances[i][k] + distances[k][j];
//                        sequence[i][j] = sequence[i][k];
                    }
                }
            }
        }
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                ans[i] += distances[i][j];
            }
        }
//        for (int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(distances[i]));
//        }
//        for (int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(sequence[i]));
//        }
        return ans;
    }
    private void setDistance(int x, int y, int value) {
        distances[x][y] = value;
        distances[y][x] = value;
    }

    /**
     * 这个解法是错误的
     * 感觉这个题应该是一个dp问题
     * 0,1 能计算出0到1的距离是1
     * 0,2 计算出0到2的距离是1
     * 那么推导出2到1的距离是2
     * 2,3 计算出2到3的距离是1
     * 推导3到0的距离是2,3到1的距离是3
     * 2,4 计算出2到4的距离是1
     * 2,5 计算出2到5的距离是1
     * 这个算法有问题，不能解决间接的距离的变化
     * @param N
     * @param edges
     * @return
     */
    public int[] sumOfDistancesInTree1(int N, int[][] edges) {
        distances = new int[N][N];
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int mino1 = Math.min(o1[0], o1[1]);
                int mino2 = Math.min(o2[0], o2[1]);
                return mino1 - mino2;
            }
        });
        for (int i = 0; i < N; i++){
            Arrays.fill(distances[i], N + 1);
            // 自己到自己的距离是0
            distances[i][i] = 0;
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            setDistance(x, y, 1);
            for (int k = 0; k < N; k++) {
                if (distances[x][k] < distances[y][k]) {
                    setDistance(y, k, distances[x][k] + 1);
                } else if (distances[y][k] < distances[x][k]) {
                    setDistance(x, k, distances[y][k] + 1);
                }
            }
        }
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans[i] += distances[i][j];
            }
        }
        return ans;
    }

}
