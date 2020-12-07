package shuwei.leetcode.cn.eight.six.one;

public class Solution {
  /**
   * 变换行，将第一列都变成1
   * 再分别从第二列开始查看，如果0多就变这列
   * @param A
   * @return
   */
  public int matrixScore(int[][] A) {
    for(int i = 0 ; i< A.length; i++) {
      if (A[i][0] == 0) {
        for (int j = 0; j < A[i].length; j++) {
          if (A[i][j] == 0){
            A[i][j] = 1;
          } else {
            A[i][j] = 0;
          }
        }
      }
    }
    for (int i = 1; i < A[0].length; i++) {
      int one = 0;
      for (int j = 0 ; j < A.length; j++) {
        if (A[j][i] == 1) {
          one++;
        }
      }
      if (one * 2 < A.length) {
        for (int j = 0; j < A.length; j++) {
          if (A[j][i] == 0) {
            A[j][i] = 1;
          } else {
            A[j][i] = 0;
          }
        }
      }
    }
    int ans = 0;
    for (int[] ele : A) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < ele.length; j++) {
        sb.append(ele[j]);
      }
      ans += Integer.parseInt(sb.toString(), 2);
    }
    return ans;
  }
}
