package shuwei.leetcode.cn.two.one.four;

public class Solution {

  /**
   * 看了题解的分析，主要思路分为： 1. 求s的最短回文，可以将s分为自己就是回文的前缀s1和多余部分s2,s2也就是在最前面需要添加的字符串的反序 2.
   * 因为s1是回文的，所以如果将s反序变成s`的话，那么s和s`的前缀匹配就是s1 3. 这个最长的前缀匹配，非常适用KMP算法求解
   * 这个题的主要思路要经常过过
   */
  public String shortestPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(s);
    String s_r = sb.reverse().toString();
    // 适用KMP求最长的前缀匹配
    int i = kmp(s_r, s);
    if (i > 0) {
      sb = new StringBuilder();
      sb.append(s.substring(i));
      return sb.reverse().toString() + s;
    } else {
      return s_r.substring(0, s.length() - 1) + s;
    }
  }

  private int kmp(String content, String pattern) {
    int[] pIndex = genPatternIndex(pattern);
    char[] s = content.toCharArray();
    char[] p = pattern.toCharArray();
    int j = 0;
    for (int i = 0; i < s.length; ) {
      if (s[i] == p[j]) {
        i++;
        j++;
      } else {
        if (j - 1 >= 0) {
          j = pIndex[j - 1];
        } else {
          i++;
        }
      }
    }
    return j;
  }

  public int[] genPatternIndex(String pattern) {
    char[] chars = pattern.toCharArray();
    int[] tmp = new int[chars.length];
    for (int i = 0, j = 1; j < chars.length; ) {
      if (chars[i] == chars[j]) {
        tmp[j++] = ++i;
      } else {
        if (i > 0) {
          i = tmp[i - 1];
        } else {
          j++;
        }
      }
    }
    return tmp;
  }

  /**
   * 思路：从中间开始，往左枚举,注意偶数回文和奇数回文 这个遇到一大堆aa的倒数第二个测试用例的时候报超时:465ms
   */
  public String shortestPalindrome2(String s) {
    String ans = null;
    char[] content = s.toCharArray();
    int length = content.length;
    int i;
    if (length % 2 == 0) {
      i = length / 2 - 1;
      ans = this.isPalind(content, i, i + 1);
      if (ans != null) {
        return ans;
      }
    } else {
      i = length / 2;
    }
    for (; i >= 0; i--) {
      ans = this.isPalind(content, i, i);
      if (ans != null) {
        return ans;
      }
      if (i - 1 >= 0) {
        ans = this.isPalind(content, i - 1, i);
        if (ans != null) {
          return ans;
        }
      }
    }
    if (ans == null) {
      StringBuilder sb = new StringBuilder();
      sb.append(s);
      sb.reverse().append(s);
      return sb.toString();
    } else {
      return ans;
    }
  }

  /**
   * 如果l和r相同表示奇数回文，如果l和r不同则表示偶数回文
   *
   * @param l 中心点左边第一个
   * @param r 中心点右边第一个
   * @return aacecaaa
   */
  private String isPalind(char[] content, int l, int r) {
    boolean same = l == r;
    StringBuilder right = new StringBuilder();
    while (l >= 0 && content[l] == content[r]) {
      right.append(content[r]);
      l--;
      r++;
    }
    // 完全匹配
    if (l < 0) {
      while (r < content.length) {
        right.append(content[r++]);
      }
      String rightStr = right.toString();
      if (same) {
        right.deleteCharAt(0).reverse().append(rightStr);
      } else {
        right.reverse().append(rightStr);
      }
      return right.toString();
    } else {
      return null;
    }
  }

}
