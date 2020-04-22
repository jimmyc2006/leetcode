package shuwei.leetcode.cn.one.three;

import java.util.HashMap;
import java.util.Map;

/** 
* @author shuwei 
* @version 创建时间：2020年4月22日 下午6:47:54 
* 类说明 
*/
public class Solution {
  static Map<Character, Integer> map = new HashMap<>();
  static {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
  }
  // 5hm,77.30%
  public int romanToInt(String s) {
    if (s == null || s.length() < 1) {
      return 0;
    }
    char[] data = s.toCharArray();
    int result = 0;
    int i; 
    for (i = data.length - 1; i > 0; i--) {
      if (data[i] == 'V' || data[i] == 'X') {
        if (data[i - 1] == 'I') {
          if (data[i] == 'V') {
            result += 4;
          } else {
            result += 9;
          }
          i--;
        } else {
          result += map.get(data[i]);
        }
      } else if (data[i] == 'L' || data[i] == 'C') {
        if (data[i - 1] == 'X') {
          if (data[i] == 'L') {
            result += 40;
          } else {
            result += 90;
          }
          i--;
        } else {
          result += map.get(data[i]);
        }
      } else if (data[i] == 'D' || data[i] == 'M') {
        if (data[i - 1] == 'C') {
          if (data[i] == 'D') {
            result += 400;
          } else {
            result += 900;
          }
          i--;
        } else {
          result += map.get(data[i]);
        }
      } else {
        result += map.get(data[i]);
      }
    }
    if (i == 0) {
      result += map.get(data[0]);
    }
    return result;
  }
}
