package shuwei.improve.bag;

public class MultiBag {
  int[] tiji = {1, 2, 3, 4};
  int[] jiazhi = {2, 4, 4, 5};
  int[] shuliang = {3, 1, 3, 2};
  int N = 4;

  // 二进制优化
  public int myMax(int maxV) {
    int[] tiji2 = new int[N * 11];
    int[] jiazhi2 = new int[N * 11];
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      int t = tiji[i];
      int j = jiazhi[i];
      int s = shuliang[i];
      int k = 1;
      while (k <= s) {
        tiji2[cnt] = t * k;
        jiazhi2[cnt] = j * k;
        cnt++;
        s = s - k;
        k = k << 1;
      }

      // 如果s本来是2的时候while循环一次，少1
      if(s > 0){
        tiji2[cnt] = t * s;
        jiazhi2[cnt] = j * s;
        cnt++;
      }
    }

    int[][] f = new int[cnt][maxV + 1];

    for (int x = 0; x < cnt; x++) {
      for (int y = 1; y <= maxV; y++) {
        if (y >= tiji2[x]) {
          if (x >= 1) {
            f[x][y] = Math.max(f[x - 1][y], f[x - 1][y - tiji2[x]] + jiazhi2[x]);
          } else {
            f[x][y] = jiazhi2[x];
          }
        } else {
          if (x >= 1) {
            f[x][y] = f[x - 1][y];
          } else {
            f[x][y] = 0;
          }
        }
//        System.out.println(x + ":" + y + " = " + f[x][y]);
      }
    }
    return f[cnt - 1][maxV];
  }

  // f[i][j] = max(f[i - 1][j], f[i - 1][j - Ktiji[i]] + Ktiji[i])
  public int myMax1(int maxV) {
    int[][] f = new int[N][maxV + 1];
    for (int i = 0; i < N; i++) {
      for (int j = 1; j <= maxV; j++) {
        int thisMax;
        if (i > 1) {
          thisMax = f[i - 1][j];
        } else {
          thisMax = 0;
        }
        int thisJ = j;
        int count = 0;
        while (thisJ >= tiji[i] && count < shuliang[i]) {
          thisJ = thisJ - tiji[i];
          count++;
          if (i < 1) {
            thisMax = Math.max(thisMax, count * jiazhi[i]);
          } else {
            thisMax = Math.max(thisMax, f[i - 1][thisJ] + jiazhi[i]);
          }
        }
        f[i][j] = thisMax;
      }
    }
    return f[N - 1][maxV];
  }
}
