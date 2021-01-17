package shuwei.leetcode.cn.eight.zero.three;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
  /**
   * 每次消除一个砖块以后，需要判断跟它相连的4个方向上的砖块是否会掉落 由于需要去除掉落的砖块，所以这个uniform需要记录连接过的砖块的位置，并且判断是否连接到顶部
   * 如果连接到顶部，那么可以不用消除，否则，就将记录的砖块都消除 由于有4个方向，所以如果之前检查过的砖块是稳固的，可以使用这些砖块判断后续三个方向的砖块，如果这三个方向跟之前稳固的砖块连接
   * 则它们也是稳固的 创建一个原二维数组的副本，来保存本次的状态使用hits的index+1来表示 还需要一个list，处理被判定为掉落的砖块的位置，可以采用dfs来处理
   * 缺少一个先检查所有可以直接掉落的节点,或者在处理某个点之前，先判断该点是否是稳固的，如果不是，结果是0，并且把连通的都设置为0
   */
  public int[] hitBricks(int[][] grid, int[][] hits) {
    xLength = grid.length;
    yLength = grid[0].length;
    // 保存每个批次是否稳固
    batchStatus = new boolean[hits.length * 4 + 1];
    currBatch = 1;
    int[][] status = new int[xLength][yLength];
    int[] ans = new int[hits.length];
    for (int i = 0; i < hits.length; i++) {
      int x = hits[i][0];
      int y = hits[i][1];
      if (grid[x][y] == 0) {
        ans[i] = 0;
        continue;
      }
      grid[x][y] = 0;
      int batchStart = currBatch;
      boolean isWengu = false;
      if (x - 1 >=0 && grid[x - 1][y] == 1) {
        ans[i] += deal(status, grid, x - 1, y, batchStart, currBatch++);
        if (grid[x - 1][y] == 1) {
          isWengu = true;
        }
      }
      if (x + 1 < xLength && grid[x + 1][y] == 1) {
        ans[i] += deal(status, grid, x + 1, y, batchStart, currBatch++);
        if (grid[x + 1][y] == 1) {
          isWengu = true;
        }
      }
      if (y - 1 >= 0 && grid[x][y - 1] == 1) {
        ans[i] += deal(status, grid, x, y - 1, batchStart, currBatch++);
        if (grid[x][y - 1] == 1) {
          isWengu = true;
        }
      }
      if (y + 1 < yLength && grid[x][y + 1] == 1) {
        ans[i] += deal(status, grid, x, y + 1, batchStart, currBatch++);
        if (grid[x][y + 1] == 1) {
          isWengu = true;
        }
      }
      if (x != 0 && (!isWengu)) {
        ans[i] = 0;
      }
    }
    return ans;
  }

  private int xLength;
  private int yLength;
  private boolean[] batchStatus;
  private int currBatch;

  // 处理一个点的掉落，返回本次掉落的数值
  private int deal(int[][] status, int[][] grid, int x, int y, int batchStart, int thisBatch) {
    if (grid[x][y] == 0) {
      return 0;
    }
    List<int[]> currList = new LinkedList<>();
    if (dfs(status, currList, grid, x, y, batchStart, thisBatch)) {
      batchStatus[thisBatch] = true;
      return 0;
    } else {
      for (int[] ele : currList) {
        grid[ele[0]][ele[1]] = 0;
      }
      return currList.size();
    }
  }

  // 改为非递归，避免栈溢出
  private boolean dfs(int[][] status, List<int[]> findList, int[][] grid, int x, int y, int batchStart, int thisBatch) {
    if (grid[x][y] == 0) {
      return true;
    }
    if (status[x][y] >= batchStart) {
      return true;
    }
    Deque<int[]> deque = new LinkedList<>();
    deque.add(new int[]{x, y});
    while (!deque.isEmpty()) {
      int[] peek = deque.peekLast();
      x = peek[0];
      y = peek[1];
      if (x == 0 && grid[x][y] == 1) {
        return true;
      }
      if (status[x][y] != thisBatch) {
        status[x][y] = thisBatch;
        findList.add(peek);
      }
      int up = x - 1;
      if (up == 0 && grid[up][y] == 1) {
        return true;
      }

      if (up > 0 && grid[up][y] == 1) {
        if (status[up][y] < batchStart) {
          deque.add(new int[]{up, y});
          continue;
        } else if(status[up][y] < thisBatch) {
          return true;
        }
      }
      int down = x + 1;
      if (down < xLength && grid[down][y] == 1) {
        if (status[down][y] < batchStart) {
          deque.add(new int[]{down, y});
          continue;
        } else if(status[down][y] < thisBatch) {
          return true;
        }
      }
      int left = y - 1;
      if (left >= 0 && grid[x][left] == 1) {
        if (status[x][left] < batchStart) {
          deque.add(new int[]{x, left});
          continue;
        } else if(status[x][left] < thisBatch) {
          return true;
        }
      }
      int right = y + 1;
      if (right< yLength && grid[x][right] == 1) {
        if (status[x][right] < batchStart) {
          deque.add(new int[]{x, right});
          continue;
        } else if(status[x][right] < thisBatch) {
          return true;
        }
      }
      deque.pollLast();
    }
    return false;
  }
  /**
   * 处理点x，y相连的点是否与顶部相连 如果可以去除，那么与x,y相连的点必然都被访问到了 如果不能去除，可能有的点不被访问到 如果本次与顶部连接了，本轮的下次访问到本次的砖块，也会被判定为稳定
   *
   * @param status    状态数组
   * @param findList  本次找到的点位，如果不连通到顶部，需要都重制为0
   * @param grid      原数组
   * @param thisBatch 第几轮，为了可以重复使用状态数组
   */
//  private boolean dfs2(int[][] status, List<int[]> findList, int[][] grid, int x, int y, int batchStart, int thisBatch) {
//    if (x == 0) {
//      return true;
//    }
//    if (status[x][y] == thisBatch) {
//      return false;
//    }
//    if (status[x][y] >= batchStart) {
//      return batchStatus[status[x][y]];
//    }
//    status[x][y] = thisBatch;
//    findList.add(new int[]{x, y});
//    if (x - 1 >= 0 && grid[x - 1][y] == 1) {
//      if (dfs(status, findList, grid, x - 1, y, batchStart, thisBatch)) {
//        return true;
//      }
//    }
//    if (x + 1 < xLength && grid[x + 1][y] == 1) {
//      if (dfs(status, findList, grid, x + 1, y, batchStart, thisBatch)) {
//        return true;
//      }
//    }
//    if (y - 1 >= 0 && grid[x][y - 1] == 1) {
//      if (dfs(status, findList, grid, x, y - 1, batchStart, thisBatch)) {
//        return true;
//      }
//    }
//    if (y + 1 < yLength && grid[x][y + 1] == 1) {
//      if (dfs(status, findList, grid, x, y + 1, batchStart, thisBatch)) {
//        return true;
//      }
//    }
//    return false;
//  }
}
