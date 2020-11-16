package shuwei.leetcode.cn.four.zero.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

  public int[][] aa(int[][] people) {
    Arrays.sort(people,(a,b)->(a[0]==b[0]?a[1]-b[1]:b[0]-a[0]));

    List<int[]> list = new ArrayList<>();

    for(int[] p: people ){
      list.add(p[1],p);
    }

    return list.toArray(new int[list.size()][]);
  }

  public int[][] reconstructQueue(int[][] people) {
    if (people.length < 1) {
      return people;
    }
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[0] == o1[0] ? o1[1] - o2[1]: o2[0]- o1[0];
      }
    });
    int[][] ans = new int[people.length][];
    int index = 0;
    for (int[] ele : people) {
      insert(ans, index++, ele);
    }
    return ans;
  }

  private void insert(int[][] ans, int length, int[] ele) {
    System.arraycopy(ans, ele[1], ans, ele[1] + 1, length - ele[1]);
    ans[ele[1]] = ele;
  }

  /**
   * 先找前面是0个的
   * 然后找下一个，如果有多个满足的化，放最小的身高
   * 例如：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
   * [5,0], [7,0]以后[5,2],[6,1],[7,1]都可以选择，那么选[5,2]因为5最小
   * 后面[6,1][7,1]可以选择，那么就选择[6,1]
   * 先将people按照身高排序，然后每次从左往右找可能填入的数值
   * @param people
   * @return
   */
  public int[][] reconstructQueue1(int[][] people) {
    if (people.length < 1) {
      return people;
    }
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    int index = 0;
    int[][] ans = new int[people.length][];
    int[] num = new int[people.length];
    while (index < people.length){
      ans[index] = select(people, num, index);
      num[index] = ans[index][0];
      index++;
    }
    return ans;
  }

  private int[] select(int[][] people, int[] num, int index) {
    for (int i = 0; i < people.length; i++) {
      if (people[i] == null) {
        continue;
      }
      int cc = 0;
      for (int j = 0; j < index; j++) {
        if (num[j] >= people[i][0]) {
          cc++;
        }
      }
      if (cc == people[i][1]) {
        int[] res = people[i];
        people[i] = null;
        return res;
      }
    }
    return null;
  }

}
