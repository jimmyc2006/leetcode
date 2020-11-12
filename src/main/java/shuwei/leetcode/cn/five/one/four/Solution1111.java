package shuwei.leetcode.cn.five.one.four;

import java.util.ArrayList;
import java.util.List;

public class Solution1111 {
  /**
   * 每一步的目标有几个对应字母，就算出来几个最近值
   * 从每一步往目标旋转的时候，都可以分为往左旋转和往右旋转
   * 使用数组保存ring中某个字母的下标
   * 再使用一个数组表示key的第几个字母最少步数，如果当前某个字母在ring中有多少，那么就会有多个值，使用int[][]来保存
   * @param ring
   * @param key
   * @return
   */
  public int findRotateSteps(String ring, String key) {
    char[] ringChars = ring.toCharArray();
    int len = ringChars.length;
    char[] keyChars = key.toCharArray();
    List<Integer>[] charIndexs = new List[26];
    for (int i = 0; i < charIndexs.length; i++) {
      charIndexs[i] = new ArrayList<>();
    }
    for (int i = 0; i < len; i++) {
      charIndexs[ringChars[i] - 'a'].add(i);
    }
    List<int[]> currentChars = new ArrayList<>();
    // 从0开始，初始0分
    currentChars.add(new int[]{0, 0});
    for (int i = 0; i < keyChars.length; i++) {
      currentChars = min(keyChars[i], len, charIndexs, currentChars);
    }
    int ans = Integer.MAX_VALUE;
    for (int[] ele : currentChars) {
      ans = Math.min(ans, ele[1]);
    }
    return ans;
  }

  /**
   * 从上一步的位置，找到下一步位置的最小步数
   * @param c
   * @param ringLength
   * @param pres
   * @return
   */
  private List<int[]> min(char c, int ringLength, List<Integer>[] charIndexs, List<int[]> pres) {
    List<int[]> result = new ArrayList<>();
    List<Integer> nexts = charIndexs[c - 'a'];
    for (int ele : nexts) {
      result.add(new int[]{ele, min(ele, ringLength, pres)});
    }
    return result;
  }

  // 计算从某些点，到达目标索引消耗的分数
  private int min(int index, int length, List<int[]> pres) {
    int result = Integer.MAX_VALUE;
    for (int[] ele : pres) {
      result = Math.min(min(index, ele[0], length) + ele[1], result);

    }
//    System.out.println("pres:" + pres + ", index:" + index + ", result:" + result);
    return result;
  }

  /**
   * 如果数组是{0, 1, 2, 3, 4, 5}
   * 那么从第3个位置到第0个位置的最短距离是Math.min(3 - 0, 0 + 6 - 3)
   * 从第4个位置到0个位置的最短距离是Math.min(4 - 1, 0 + 6 - 4)
   * @param to
   * @param from
   * @return
   */
  private int min(int to, int from, int length) {
    if (from >= to) {
      return Math.min(from - to, to + length - from) + 1;
    } else {
      return Math.min(to - from, from + length - to) + 1;
    }
  }
}
