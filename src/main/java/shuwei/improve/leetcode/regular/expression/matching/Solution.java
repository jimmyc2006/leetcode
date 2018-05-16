package shuwei.improve.leetcode.regular.expression.matching;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shuwei
 * @version 创建时间：2017年8月28日 下午8:53:21 类说明
 */
public class Solution {

    char[] txt;
    char[] regex;

    public boolean isMatch(String s1, String p1) {
        char[] txt = s1.toCharArray();
        char[] regex = p1.toCharArray();
        boolean[][] dp = new boolean[txt.length + 1][regex.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < regex.length; i++) {
            if (regex[i] == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < txt.length; i++) {
            for (int j = 0; j < regex.length; j++) {
                if (regex[j] == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (regex[j] == txt[i]) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (regex[j] == '*') {
                    if (regex[j - 1] != txt[i] && regex[j - 1] != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[txt.length][regex.length];
    }


    // 《代码之美》
    public boolean isMatch_4(String s, String p) {
        txt = s.toCharArray();
        regex = p.toCharArray();
        return matchHere(0, 0);
    }

    private boolean matchHere(int regIndex, int txtIndex) {
        if (regIndex == regex.length) {
            return txtIndex == txt.length;
        }
        if (regIndex + 1 < regex.length && regex[regIndex + 1] == '*') {
            return matchChar(regex[regIndex], regIndex + 2, txtIndex);
        }
        if (txtIndex == txt.length && regIndex != regex.length) {
            return false;
        }
        if (regex[regIndex] == txt[txtIndex] || regex[regIndex] == '.') {
            return matchHere(regIndex + 1, txtIndex + 1);
        } else {
            return false;
        }
    }

    private boolean matchChar(char starChar, int regIndex, int txtIndex) {
        do {
            if (matchHere(regIndex, txtIndex)) {
                return true;
            }
        } while (txtIndex < txt.length && (txt[txtIndex++] == starChar || starChar == '.'));
        return false;
    }

    /**
     * 尝试使用《代码之美》上的方法,自己凭记忆写出来的
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_3(String s, String p) {
        txt = s.toCharArray();
        regex = p.toCharArray();
        return matchHere_2(0, 0);
    }

    private boolean matchHere_2(int i, int j) {
        System.out.println(i + "::" + j);
        if (j + 1 < regex.length && regex[j + 1] == '*') {
            if (matchHere_2(i, j + 2)) {
                return true;
            }
        }
        if (j == regex.length) {
            if (i == txt.length) {
                return true;
            } else {
                return false;
            }
        }
        if (i == txt.length && j != regex.length) {
            return false;
        }
        if (txt[i] == regex[j] || regex[j] == '.') {
            if (j + 1 < regex.length && regex[j + 1] == '*') {
                return matchHere_2(i + 1, j);
            } else {
                return matchHere_2(i + 1, j + 1);
            }
        } else {
            return false;
        }
    }

    List<Integer>[] adjs;
    boolean[] marked;

    /**
     * 使用NFA，DFS思路解决，性能不太好，只能超过30%的人,参考《算法》
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_2(String s, String p) {
        regex = p.toCharArray();
        adjs = new List[regex.length + 1];
        for (int i = 0; i < adjs.length; i++) {
            adjs[i] = new ArrayList<Integer>();
            if (i < regex.length && regex[i] == '*') {
                adjs[i].add(i + 1);
                adjs[i].add(i - 1);
                adjs[i - 1].add(i);
            }
        }
        txt = s.toCharArray();
        Set<Integer> matches = new HashSet<>();
        matches.add(0);
        List<Integer> heads = findHeads(matches);
        for (int i = 0; i < txt.length; i++) {
            matches.clear();
            for (int index : heads) {
                if (index < regex.length && (txt[i] == regex[index] || regex[index] == '.')) {
                    matches.add(index + 1);
                }
            }
            heads = findHeads(matches);
        }
        if (heads.contains(regex.length)) {
            return true;
        } else {
            return false;
        }
    }

    private List<Integer> findHeads(Set<Integer> heads) {
        marked = new boolean[regex.length + 1];
        for (int s : heads) {
            findHead(s);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) {
                result.add(i);
            }
        }
        return result;
    }

    private void findHead(int source) {
        marked[source] = true;
        for (int w : adjs[source]) {
            if (!marked[w]) {
                findHead(w);
            }
        }
    }

    public boolean isMatch_1(String s, String p) {
        // p中不能出现**,第一个字符不能是*
        if (p.length() == 0 && s.length() != 0) {
            return false;
        }
        return isMatch_1(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean isMatch_1(char[] src, int sStart, char[] regex, int rStart) {
        int i = sStart;
        int j = rStart;
        char beforeStarChar = ' ';
        boolean isInStar = false;
        while (i < src.length) {
            if (isInStar) {
                if (j < regex.length && isMatch_1(src, i, regex, j)) {
                    return true;
                } else {
                    if (beforeStarChar == '.' || beforeStarChar == src[i]) {
                        i++;
                    } else {
                        if (j < regex.length && src[i] == regex[j]) {
                            isInStar = false;
                            i++;
                            j++;
                        } else {
                            return false;
                        }
                    }
                }
            } else {
                if (j >= regex.length) {
                    return false;
                }
                if (regex[j] == '*') {
                    isInStar = true;
                    beforeStarChar = regex[j - 1];
                    j++;
                } else {
                    if (src[i] == regex[j] || regex[j] == '.') {
                        i++;
                        j++;
                        if (j < regex.length && regex[j] == '*') {
                            isInStar = true;
                            beforeStarChar = regex[j - 1];
                            i--;
                            j++;
                        }
                    } else {
                        if (j + 1 < regex.length && regex[j + 1] == '*') {
                            j += 2;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        while (j + 1 < regex.length && regex[j + 1] == '*') {
            j += 2;
        }
        if (j == regex.length) {
            return true;
        } else if (isInStar) {
            if (isMatch_1(src, i - 1, regex, j)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("ab", ".*c"));
        // Solution s = new Solution();
        // System.out.println(s.isMatch("bbbba", ".*a*a"));
    }
}
