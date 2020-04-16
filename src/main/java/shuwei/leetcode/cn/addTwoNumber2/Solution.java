package shuwei.leetcode.cn.addTwoNumber2;

/** 
* @version 创建时间：2020年4月14日 下午2:53:49 
* 类说明 
*/
public class Solution {
  public static void main(String[] args) {
    ListNode l1 = generate(1);
    ListNode l2 = generate(9, 9);
    Solution s = new Solution();
    System.out.println(traversal(l1));
    System.out.println(traversal(l2));
    System.out.println(traversal(s.addTwoNumbers(l1, l2)));
  }
  
  public static String traversal(ListNode ln) {
    StringBuilder sb = new StringBuilder();
    sb.append(ln.val);
    while (ln.next != null) {
      ln = ln.next;
      sb.append("->" + ln.val);
    }
    return sb.toString();
  }  
  public static ListNode generate(int start, int... vals) {
    ListNode root = new ListNode(start);
    ListNode curr = root;
    for (int i : vals) {
      ListNode next = new ListNode(i);
      curr.next = next;
      curr = next;
      
    }
    return root;
  }
  
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    String s1 = List2String(l1);
    String s2 = List2String(l2);
    int i = s1.length() - 1, j = s2.length() - 1;
    ListNode curNode = new ListNode(0);
    int cur = 0;
    ListNode next = null;
    while (i >= 0 || j >= 0) {
      if (i >= 0 && j >= 0) {
        cur = Integer.parseInt(String.valueOf(s1.charAt(i))) + Integer.parseInt(String.valueOf(s2.charAt(j))) + curNode.val;
        i--;
        j--;
      } else if (i >= 0) {
        cur = Integer.parseInt(String.valueOf(s1.charAt(i)))+ curNode.val;
        i--;
      } else if (j >= 0) {
        cur = Integer.parseInt(String.valueOf(s2.charAt(j)))+ curNode.val;
        j--;
      }
      next = curNode;
      if (cur >= 10) {
        curNode = new ListNode(1);
        cur = cur - 10;
      } else {
        curNode = new ListNode(0);
      }
      next.val = cur;
      curNode.next = next;
    }
    if (curNode.val > 0) {
      return curNode;
    } else {
      return next;
    }
  }
  
  public String List2String(ListNode ln) {
    StringBuilder sb = new StringBuilder();
    while (ln != null) {
      sb.append(ln.val);
      ln = ln.next;
    }
    return sb.toString();
  }
}
