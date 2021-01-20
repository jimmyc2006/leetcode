package shuwei.leetcode.cn.seven.two.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
  /**
   * 使用一个map，key是邮箱，value是邮箱所属的账户的索引
   * 使用一个数组表示账户索引
   * @param accounts
   * @return
   */
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int length = accounts.size();
    Map<String, Integer> mail2Name = new TreeMap<>();
    Uniform u = new Uniform(length);
    List<List<String>> ans = new ArrayList<>();
    for (int i = 0; i < accounts.size(); i++) {
      List<String> strings = accounts.get(i);
      String name = strings.get(0);
      if (strings.size() > 1) {
        for (int j = 1; j < strings.size(); j++) {
          String mail = strings.get(j);
          Integer index = mail2Name.get(mail);
          if (index != null && index != i) {
            u.union(index, i);
          } else {
            mail2Name.put(mail, i);
          }
        }
      } else {
        ans.add(Arrays.asList(name));
      }
    }
    Map<Integer, List<String>> index2Mails = new HashMap<>();
    for (Map.Entry<String, Integer> entry : mail2Name.entrySet()) {
      int r = u.find(entry.getValue());
      List<String> mailList = index2Mails.get(r);
      if (mailList == null) {
        mailList = new ArrayList<>();
        mailList.add(accounts.get(r).get(0));
        ans.add(mailList);
        index2Mails.put(r, mailList);
      }
      mailList.add(entry.getKey());
    }
    return ans;
  }
}
class Uniform {
  private int[] points;
  private int group;

  public Uniform(int N) {
    group = N;
    points = new int[N];
    for (int i = 0; i < N; i++) {
      points[i] = i;
    }
  }

  public int find(int point) {
    if (point != points[point]) {
      points[point] = find(points[point]);
    }
    return points[point];
  }

  public void union(int p1, int p2) {
    int p1f = find(p1);
    int p2f = find(p2);
    if (p1f == p2f) {
      return;
    }
    points[p1f] = p2f;
    group--;
  }

  public int getGroup() {
    return group;
  }
}