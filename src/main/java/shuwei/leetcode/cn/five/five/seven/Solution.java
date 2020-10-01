package shuwei.leetcode.cn.five.five.seven;

public class Solution {
  // 这个比较快3ms，但是兼容性稍微差点，必须严格单词和一个空格
  public String reverseWords(String s) {
    char[] contents = s.toCharArray();
    int start = 0;
    for (int i = 0; i < contents.length; i++) {
      if (contents[i] == ' ') {
        reverseChar(contents, start, i - 1);
        start = i + 1;
      }
    }
    reverseChar(contents, start, contents.length - 1);
    return new String(contents);
  }

  private void reverseChar(char[] content, int start, int end) {
    while (start < end) {
      char tmp = content[start];
      content[start] = content[end];
      content[end] = tmp;
      start++;
      end--;
    }
  }

  // 先倒序编译，放在sb中
  // 速度比较慢9 ms41%，再优化下
  public String reverseWords1(String s) {
    StringBuilder sb= new StringBuilder();
    String[] strs = s.split(" ");
    for (String eles : strs) {
      sb.append(reverse(eles) + " ");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  private String reverse(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      sb.append(str.charAt(i));
    }
    return sb.toString();
  }

}
