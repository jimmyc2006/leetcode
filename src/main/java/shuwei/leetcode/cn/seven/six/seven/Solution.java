package shuwei.leetcode.cn.seven.six.seven;

public class Solution {

  /**
   * 计算每个字母的总数量，然后根据数量排序，然后从多到少，先填满偶数，然后再填满奇数位置
   * @param S
   * @return
   */
  public String reorganizeString(String S) {
    if (S.length() < 2) {
      return S;
    }
    char[] chars = S.toCharArray();
    int[] charCount = new int[26];
    int charC = 0;
    for (char ele : chars) {
      charCount[ele -'a']++;
    }
    int max = 0;
    int maxIndex = -1;
    for (int i = 0; i < charCount.length; i++) {
      if (charCount[i] > max) {
        max = charCount[i];
        maxIndex = i;
      }
    }
    if (max > chars.length / 2 + chars.length % 2) {
      return "";
    }
    int index = 0;
    for (int i = 0; i < max; i++) {
      chars[index] = (char)(maxIndex + 'a');
      index += 2;
    }
    charCount[maxIndex] = 0;
    for (int i = 0 ; i < charCount.length; i++) {
      while (charCount[i] > 0) {
        if (index >= chars.length) {
          index = 1;
        }
        chars[index] = (char)(i + 'a');
        charCount[i]--;
        index += 2;
      }
    }
    return new String(chars);
  }

}
