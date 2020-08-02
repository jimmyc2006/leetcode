package shuwei.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

  public static<T> List<List<T>> toList(T[][] param) {
    List<List<T>> result = new ArrayList<>();
    for (T[] first : param) {
      List<T> list = new ArrayList<>();
      for (T two : first) {
        list.add(two);
      }
      result.add(list);
    }
    return result;
  }
}
