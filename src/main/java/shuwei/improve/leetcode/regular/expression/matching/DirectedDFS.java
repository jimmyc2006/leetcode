package shuwei.improve.leetcode.regular.expression.matching;
import java.util.ArrayList;
import java.util.List;

public class DirectedDFS {
    private boolean[] marked;
    
    // 单个起点
    public DirectedDFS(Digraph digraph, int s) {
        marked = new boolean[digraph.getPointsCount()];
        dfs(digraph, s);
    }
    
    // 多个起点
    public DirectedDFS(Digraph digraph, Iterable<Integer> sources) {
        marked = new boolean[digraph.getPointsCount()];
        for(int s : sources) {
            if(!marked[s]) {
                dfs(digraph, s);
            }
        }
    }
    
    private void dfs (Digraph digraph, int pointIndex) {
        marked[pointIndex] = true;
        for(int w : digraph.adj(pointIndex)) {
            if(!marked[w]) {
                dfs(digraph, w);
            }
        }
    }
    
    public boolean marked(int v) {
        return marked[v];
    }
    
    public static void main(String[] args) {
        Digraph digraph = new Digraph(6);
        List<Integer> sources = new ArrayList<>();
        sources.add(0);
        sources.add(2);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 5);
        DirectedDFS dDfs = new DirectedDFS(digraph, sources);
        for(int i = 0; i < digraph.getPointsCount(); i++) {
            if(dDfs.marked(i) == false) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}