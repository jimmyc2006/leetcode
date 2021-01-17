package shuwei.leetcode.cn.one.two.zero.two.shuwei.leetcode.cn.one.two.zero.two;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class SSolution {

  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    char[] chars = s.toCharArray();
    int length = chars.length;
    Set<Integer>[] indexs = new Set[length];
    for (List<Integer> elePair : pairs) {
      int i1 = elePair.get(0);
      int i2 = elePair.get(1);
      if (indexs[i1] == null && indexs[i2] == null) {
        indexs[i1] = indexs[i2] = new HashSet<>();
        indexs[i1].add(i2);
        indexs[i1].add(i1);
      } else if (indexs[i1] == null && indexs[i2] != null) {
        indexs[i1] = indexs[i2];
        indexs[i2].add(i1);
      } else if (indexs[i2] == null && indexs[i1] != null) {
        indexs[i2] = indexs[i1];
        indexs[i2].add(i2);
      } else {
        indexs[i1].addAll(indexs[i2]);
        for (int ind : indexs[i2]) {
          indexs[ind] = indexs[i1];
        }
      }
    }
    Map<Set, PriorityQueue<Character>> dataMap = new HashMap<>();
    for (Set<Integer> inds : indexs) {
      if (inds == null) {
        continue;
      }
      PriorityQueue<Character> characters = dataMap.get(inds);
      if (characters == null) {
        characters = new PriorityQueue<>();
        dataMap.put(inds, characters);
        for (Integer ele : inds) {
          characters.add(chars[ele]);
        }
      }
    }
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if (indexs[i] == null) {
        ans.append(chars[i]);
        continue;
      }
      ans.append(dataMap.get(indexs[i]).poll());
    }
    return ans.toString();
  }
}
