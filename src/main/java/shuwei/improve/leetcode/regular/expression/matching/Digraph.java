package shuwei.improve.leetcode.regular.expression.matching;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shuwei
 * @version 创建时间：2017年8月31日 上午9:10:37
 * 类说明
 */
public class Digraph {
    private final int pointsCount;
    private int edgeCount;
    private List<Integer>[] adj;
    
    public Digraph(int pointsCount) {
        this.pointsCount = pointsCount;
        this.edgeCount = 0;
        adj = new List[pointsCount];
        for(int i = 0; i < pointsCount; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }
    
    public int getPointsCount() {
        return pointsCount;
    }
    public int getEdgeCount() {
        return this.edgeCount;
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);
        edgeCount++;
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}