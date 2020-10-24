package shuwei.leetcode.cn.one.zero.two.four;

public class Solution {

  /**
   * 贪心算：遍历一边数组，拿到每个起始点一步能到达的最远的距离
   * @param clips
   * @param T
   * @return
   */
  public int videoStitching(int[][] clips, int T) {
    int[] oneStepMax = new int[T + 1];
    for (int[] ele : clips) {
      if (ele[0] < T) {
        oneStepMax[ele[0]] = Math.max(oneStepMax[ele[0]], ele[1]);
      }
    }
    int currMax = 0;
    int nextMax = oneStepMax[0];
    int ans = 1;
    while (nextMax < T) {
      int next = 0;
      for (int i = currMax + 1; i <= nextMax; i++) {
        next = Math.max(oneStepMax[i], next);
      }
      if (next <= nextMax) {
        return -1;
      }
      currMax = nextMax;
      nextMax = next;
      ans++;
    }
    return ans;
  }

}
