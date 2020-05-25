package shuwei.improve.accu.string;

public class Kmp {

  public int kmpMatch(String src, String pattern) {
    char[] srcChars = src.toCharArray();
    char[] patternChars = pattern.toCharArray();
    int[] patterIndex = this.genPatternIndex(pattern);
    for (int i = 0, j = 0; i < srcChars.length; ) {
      if (srcChars[i] == patternChars[j]) {
        if (j == patternChars.length - 1) {
          return i - patternChars.length + 1;
        }
        i++;
        j++;
      } else {
        if (j - 1 >= 0) {
          j = patterIndex[j - 1];
        } else {
          i++;
        }
      }
    }
    return -1;
  }

  // 构造中间数组
  public int[] genPatternIndex(String pattern) {
    char[] chars = pattern.toCharArray();
    int[] tmp = new int[chars.length];
    for (int i = 0, j = 1; j < chars.length;) {
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

}
