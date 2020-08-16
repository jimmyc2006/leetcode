package shuwei.leetcode.seven.three.three;

public class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int src = image[sr][sc];
    if (src != newColor) {
      dfs(image, sr, sc, src, newColor);
    }
    return image;
  }

  // dfs
  private void dfs (int[][] image, int sr, int sc, int src, int dst) {
    if (image[sr][sc] == src) {
      image[sr][sc] = dst;
      if (sr - 1 >= 0) {
        dfs(image, sr - 1, sc, src, dst);
      }
      if (sr + 1 < image.length) {
        dfs(image, sr + 1, sc, src, dst);
      }
      if (sc - 1 >= 0) {
        dfs(image, sr, sc - 1, src, dst);
      }
      if (sc + 1 < image[sr].length) {
        dfs(image, sr, sc + 1, src, dst);
      }
    }
  }
}
