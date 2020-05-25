package shuwei.improve.dsaj.one.three;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
  private final int MAX_VERTS = 20;
  private Vertex vertexList[];
  private int adjMat[][];
  private int nVerts;
  private StackX theStack;

  public Graph() {
    vertexList = new Vertex[MAX_VERTS];
    adjMat = new int[MAX_VERTS][MAX_VERTS];
    nVerts = 0;
    for (int j = 0; j < MAX_VERTS; j++) {
      for (int k = 0; k < MAX_VERTS; k++) {
        adjMat[j][k] = 0;
      }
    }
    theStack = new StackX();
  }

  public void addVertex (char lab) {
    vertexList[nVerts++] = new Vertex(lab);
  }

  public void addEdge (int start, int end) {
    adjMat[start][end] = 1;
    adjMat[end][start] = 1;
  }

  public void displayVertex(int v) {
    System.out.print(vertexList[v].label);
  }

  public int getAdjUnvisitedVertex (int v) {
    for (int j = 0; j < nVerts; j++) {
      if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
        return j;
      }
    }
    return -1;
  }

  public void dfs () {
    vertexList[0].wasVisited = true;
    this.displayVertex(0);
    theStack.push(0);

    while(!theStack.isEmpty()) {
      int v = this.getAdjUnvisitedVertex(theStack.peek());
      if (v == -1) {
        theStack.pop();
      } else {
        vertexList[v].wasVisited = true;
        this.displayVertex(v);
        theStack.push(v);
      }
    }

    // 完事以后还原状态
    for (int j = 0; j < nVerts; j++) {
      vertexList[j].wasVisited = false;
    }
  }

  public void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    this.displayVertex(0);
    this.vertexList[0].wasVisited = true;
    queue.add(0);
    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      int adjUnvisitedVertex;
      while ((adjUnvisitedVertex = this.getAdjUnvisitedVertex(poll)) != -1) {
        this.displayVertex(adjUnvisitedVertex);
        vertexList[adjUnvisitedVertex].wasVisited = true;
        queue.add(adjUnvisitedVertex);
      }
    }

    for (int j = 0; j < nVerts; j++) {
      vertexList[j].wasVisited = false;
    }
  }

  // 最小生成树
  public void mst() {
    vertexList[0].wasVisited = true;
    theStack.push(0);

    while (!theStack.isEmpty()) {
      int currentVertex = theStack.peek();
      int v = this.getAdjUnvisitedVertex(currentVertex);
      if (v == -1) {
        theStack.pop();
      } else {
        vertexList[v].wasVisited = true;
        theStack.push(v);

        this.displayVertex(currentVertex);
        this.displayVertex(v);
        System.out.print(" ");
      }
    }
    for (int j = 0; j < nVerts; j++) {
      vertexList[j].wasVisited = false;
    }
  }

  public int[][] warshall() {
    // 复制一个关系矩阵
    int result[][] = new int[nVerts][nVerts];
    for (int i = 0; i < nVerts; i++) {
      for (int j = 0; j < nVerts; j++) {
        result[i][j] = this.adjMat[i][j];
      }
    }
    for (int i = 0; i < nVerts; i++) {
      for (int j = 0; j < nVerts; j++) {
        if (result[i][j] == 1) {
          for (int k = 0; k <nVerts; k++) {
            if (result[k][i] == 1) {
              result[k][j] = 1;
            }
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Graph theGraph = new Graph();
    theGraph.addVertex('A');
    theGraph.addVertex('B');
    theGraph.addVertex('C');
    theGraph.addVertex('D');
    theGraph.addVertex('E');

    theGraph.addEdge(0, 1);
    theGraph.addEdge(1, 2);
    theGraph.addEdge(0, 3);
    theGraph.addEdge(3, 4);

    System.out.print("Visit: ");
    theGraph.dfs();
    System.out.println();
    theGraph.bfs();
    System.out.println();
    theGraph.mst();
    System.out.println();
  }
}