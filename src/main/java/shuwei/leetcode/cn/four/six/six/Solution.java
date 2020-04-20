package shuwei.leetcode.cn.four.six.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author shuwei
 * @version 创建时间：2020年4月19日 下午5:00:23 类说明
 */
public class Solution {

  // 再次思考后，不断修正的版本，刚好能通过的自写版本,思路还是参考了官方答案
  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    // key是s2为0时候，s1的坐标,值是当时的i和s2的个数
    Map<Integer, int[]> map = new HashMap<>();
    int s2Count = 0;
    int s2Circle = 0;
    StringBuilder sb1 = new StringBuilder(s1);
    for (int i = 0, j = 0; i < s1.length() * n1;) {
      if (s2.charAt(j) == sb1.charAt(i)) {
        if (j == 0) {
          int[] data = map.get(i % s1.length());
          if (data == null) {
            map.put(i % s1.length(), new int[]{i, s2Count});
          } else {
            // 找到相同的开始点
            s2Circle = s2Count - data[1];
            int circleS1Length = i - data[0];
            // 包含多少个
            int countNum = (s1.length() * n1 - data[0]) / circleS1Length;
            s2Count = data[1] + countNum * s2Circle;
            // 剩余部分
            sb1 = new StringBuilder(s1);
            for (int m = i % s1.length(), n = 0; m < s1.length() * n1 - (circleS1Length * countNum + data[0]) + (i % s1.length());) {
              if (s2.charAt(n) == sb1.charAt(m)) {
                n++;
                if (n >= s2.length()) {
                  n = 0;
                  s2Count++;
                }
              }
              m++;
              if (m % s1.length() == 0) {
                sb1.append(s1);
              }
            }
            break;
          }
        }
        j++;
        if (j >= s2.length()) {
          j = 0;
          s2Count++;
        }
      }
      i++;
      if (i % s1.length() == 0) {
        sb1.append(s1);
      }
    }
    return s2Count / n2;
  }
  
  // 查看了官方解题思路中的循环节的方法-寻找循环节的思路错了
  public int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
    int s1Length = s1.length() * n1;
    // key是s1的次数,value是s2的次数
    TreeMap<Integer, Integer> tm = new TreeMap<>();
    StringBuilder sb1 = new StringBuilder(s1);
    // 试图找出循环节
    int s1Count = 1;
    int s2Count = 0;
    int endS1 = 0;
    for (int i = 0, j = 0; i < s1Length;) {
      if (sb1.charAt(i) == s2.charAt(j)) {
        j++;
        if (j >= s2.length()) {
          // 成功匹配一次s2
          j = 0;
          s2Count++;
          tm.put(s1Count, s2Count);
          if (tm.size() > 2) {
            endS1 = i % s1.length() + 1;
            // 如果有3个成员，那么第1个就是前置结果，第2个减去第1个就是循环节
            break;
          }
        }
      }
      i++;
      if (i >= s1.length()) {
        if (i % s1.length() == 0) {
          s1Count++;
          sb1.append(s1);
        }
      }
    }
    if (tm.size() > 2) {
      int i = 0;
      int first = 0, second = 0;
      // 计算循环节
      for (int s1Times : tm.keySet()) {
        if (i == 0) {
          first = s1Times;
        } else if (i == 1) {
          second = s1Times;
          break;
        }
        i++;
      }
      int circleS1 = second - first;
      int circleS2 = tm.get(second) - tm.get(first);
      // 计算s2在循环节结束时候出现的次数
      int tmpS2Sum = (n1 - first) / circleS1 * circleS2 + tm.get(first);
      // 循环节可能剩余s1的个数
      int reamainS1Count = (n1 - first) % circleS1;
      // 算循环节结束时候包含多少个s2 * n2
      int tmpResult = tmpS2Sum / n2;
      StringBuilder s1Remain = new StringBuilder(s1.substring(endS1));
      for (int k = 0; k < reamainS1Count; k++) {
        s1Remain.append(s1);
      }
      int findS2Count = 0;
      for (int j = 0, k = 0; j < s1Remain.length();) {
        if (s2.charAt(k) == s1Remain.charAt(j)) {
          k++;
          if (k >= s2.length()) {
            findS2Count++;
            k = 0;
          }
        }
        j++;
      }
      tmpResult = tmpResult + (tmpS2Sum % n2 + findS2Count) / n2;
      return tmpResult;
    } else {
      return s2Count;
    }
  }

  // 暴力方法，不能满足性能需求
  public int getMaxRepetitions1(String s1, int n1, String s2, int n2) {
    StringBuilder sb1 = new StringBuilder(s1.length() * n1);
    for (int i = 0; i < n1; i++) {
      sb1.append(s1);
    }
    StringBuilder sb2 = new StringBuilder(s2.length() * n2);
    for (int i = 0; i < n2; i++) {
      sb2.append(s2);
    }
    int result = 0;
    List<Integer> p = new ArrayList<>();
    for (int i = 0, j = 0; j < s1.length() * n1;) {
      char currC = sb2.charAt(i);
      if (sb1.charAt(j) == currC) {
        i++;
        j++;
        if (i >= sb2.length()) {
          // 理论上会出现n个长度出现一次匹配
          result++;
          System.out.println(result + ":" + j);
          p.add(j - 1);
          // 如果出现等差数列
          i = 0;
        }
      } else {
        j++;
      }
    }
    System.out.println(p);
    return result;
  }
}
