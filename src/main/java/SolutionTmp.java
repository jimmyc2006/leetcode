public class SolutionTmp {
  public static void main(String[] args) {
    SolutionTmp st = new SolutionTmp();
    System.out.println(st.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    System.out.println(st.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
    System.out.print(st.isBipartite(new int[][]{{2, 4}, {2, 3, 4}, {0, 1}, {1}, {0, 1}, {7},
            {9}, {5}, {}, {6}, {12, 14}, {}, {10}, {}, {10}, {19}, {18}, {}, {16}, {15},
            {23}, {23}, {}, {20, 21}, {}, {}, {27}, {26}, {}, {}, {34}, {33, 34}, {},
            {31}, {30, 31}, {38, 39}, {37, 38, 39}, {36}, {35, 36}, {35, 36}, {43},
            {}, {}, {40}, {}, {49}, {47, 48, 49}, {46, 48, 49}, {46, 47, 49}, {45, 46, 47, 48}}));
  }


  private int[] b;
  private int[] v;
  private static final int A = 1;

  public boolean isBipartite(int[][] graph) {
    if (graph.length < 1) {
      return true;
    }
    b = new int[graph.length];
    v = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (b[i] == 0) {
        if (!isBi(graph, i, A)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isBi(int[][] graph, int i, int val) {
    if (v[i] != 0 && v[i] != val) {
      return false;
    }
    if (b[i] != 0) {
      return true;
    } else {
      b[i] = A;
    }
    v[i] = val;
    for (int j = 0; j < graph[i].length; j++) {
      if (!isBi(graph, graph[i][j], -val)) {
        return false;
      }
    }
    return true;
  }
}
