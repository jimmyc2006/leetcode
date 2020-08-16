package shuwei.leetcode.cn.four.three;

public class SolutionBak20200814 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        multiResult = new String[10];
        char[] content1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        String ans = "0";
        StringBuilder zeros = new StringBuilder();
        for (int i = chars2.length - 1; i >= 0; i--) {
            String curStr = multi(content1, chars2[i]);
            ans = add(ans, curStr + zeros.toString());
            zeros.append('0');
        }
        return ans;
    }

    private String[] multiResult;

    public String add(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int remain = 0;
        for (int i = c1.length - 1, j = c2.length - 1; i >= 0 || j >= 0;) {
            int curr = remain;
            if (i >= 0) {
                curr += c1[i--] - '0';
            }
            if (j >= 0) {
                curr += c2[j--] - '0';
            }
            remain = curr / 10;
            result.append(curr % 10);
        }
        if (remain > 0 ){
            result.append(remain);
        }
        return result.reverse().toString();
    }

    private String multi(char[] content, char ch) {
        if (ch == '0') {
            return "0";
        }
        if (multiResult[ch - '0'] == null) {
            int remain = 0;
            StringBuilder res = new StringBuilder();
            for (int i = content.length - 1; i >= 0; i--) {
                int currValue = (content[i] - '0') * (ch - '0') + remain;
                res.append(currValue % 10);
                remain = currValue / 10;
            }
            if (remain > 0) {
                res.append(remain);
            }
            multiResult[ch - '0'] = res.reverse().toString();
        }
        return multiResult[ch - '0'];
    }
}
