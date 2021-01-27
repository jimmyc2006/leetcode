package shuwei.leetcode.cn.one.five.seven.nine;

import java.util.ArrayList;
import java.util.List;

import shuwei.leetcode.cn.Uniform;

public class Solution {
  /**
   * 由于每2个点之间有一条线，所以Alice和Bob如果能遍历，富余的关系数量是一定的
   * 应该尽量选择更多的公共边，所以先遍历公共边，找出多余的边的数量
   * 然后再遍历Alice和Bob的边，算出各自的多余的关系数
   * 3个数加起来获取最终结果
   * @param n
   * @param edges
   * @return
   */
  public int maxNumEdgesToRemove(int n, int[][] edges) {
    int ans = 0;
    Uniform uniformAlice = new Uniform(n + 1);
    Uniform uniformBob = new Uniform(n + 1);
    List<int[]> aliceEdges = new ArrayList<>();
    List<int[]> bobEdges = new ArrayList<>();
    for (int[] ele : edges) {
      if (ele[0] == 1) {
        aliceEdges.add(ele);
      } else if (ele[0] == 2) {
        bobEdges.add(ele);
      } else {
        if (!uniformAlice.union(ele[1], ele[2])) {
          ans++;
        }
        uniformBob.union(ele[1], ele[2]);
      }
    }
    int aliceMore = findMore(uniformAlice, aliceEdges);
    if (aliceMore == -1) {
      return -1;
    }
    int bobMore = findMore(uniformBob, bobEdges);
    if (bobMore == -1) {
      return -1;
    }
    return ans + aliceMore + bobMore;
  }

  private int findMore(Uniform uniform, List<int[]> edges) {
    int result = 0;
    for (int i = 0; i < edges.size(); i++) {
      if (uniform.getGroup() == 2) {
        return result + edges.size() - i;
      }
      if (!uniform.union(edges.get(i)[1], edges.get(i)[2])) {
        result++;
      }
    }
    if (uniform.getGroup() == 2) {
      return result;
    } else {
      return -1;
    }
  }
}
