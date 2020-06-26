package shuwei.leetcode.cn;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public static ListNode gen(String info) {
    if (info.startsWith("[")) {
      info = info.substring(1);
    }
    if (info.endsWith("]")) {
      info = info.substring(0, info.length() - 1);
    }
    String[] strs = info.split(",");
    ListNode root = null, cur = null;
    for (String num : strs) {
      if (root == null) {
        root = new ListNode(Integer.parseInt(num.trim()));
        cur = root;
      } else {
        cur.next = new ListNode(Integer.parseInt(num.trim()));
        cur = cur.next;
      }
    }
    return root;
  }

  public String b2String () {
    StringBuilder sb = new StringBuilder();
    sb.append(this.val);
    ListNode next = this.next;
    while (next != null) {
      sb.append("," + next.val);
      next = next.next;
    }
    return sb.toString();
  }
}
