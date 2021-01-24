package shuwei.leetcode.cn.nine.eight.nine;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  /**
   * 由于k<=10000,那么直接拿A的前5位数与k相加，如果结果还是5位，直接改变A的最后5个数即可
   * 如果结果超过5位，那么将后5位替换，然后在从第6位开始，计算，如果>=10就进1，依次类推
   * @param A
   * @param K
   * @return
   */
  public List<Integer> addToArrayForm(int[] A, int K) {
    // 可以转为long
    if (A.length <= 18) {
      long a = array2num(A, A.length);
      a += K;
      return long2List(a);
    }
    int b = (int) array2num(A, 5);
    int c = b + K;
    LinkedList<Integer> res = long2List(c);
    int remain;
    if (c < 100000) {
      for (int i = res.size(); i < 5; i++) {
        res.addFirst(0);
      }
      remain = 0;
    } else {
      remain = 1;
      res.removeFirst();
    }
    for (int i = A.length - 6; i >= 0; i--) {
      if (remain > 0) {
        int tmp = A[i] + remain;
        if (tmp < 10) {
          res.addFirst(tmp);
          remain = 0;
        } else {
          res.addFirst(tmp % 10);
          remain = 1;
        }
      } else {
        res.addFirst(A[i]);
      }
    }
    if (remain > 0) {
      res.addFirst(remain);
    }
    return res;
  }

  private long array2num(int[] A, int length) {
    long res = 0;
    for (int i = A.length - length ; i < A.length; i++) {
      res = res * 10 + A[i];
    }
    return res;
  }

  private LinkedList<Integer> long2List(long num) {
    LinkedList<Integer> res = new LinkedList<>();
    if (num == 0) {
      res.add(0);
      return res;
    }
    while (num > 0) {
      int remain = (int) (num % 10);
      res.addFirst(remain);
      num = num / 10;
    }
    return res;
  }
}
