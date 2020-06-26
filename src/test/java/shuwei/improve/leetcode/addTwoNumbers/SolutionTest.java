package shuwei.improve.leetcode.addTwoNumbers;
import org.junit.Test;

import shuwei.leetcode.cn.ListNode;


/**
 * @author shuwei
 * @version 创建时间：2017年8月23日 下午8:34:13 类说明
 */
public class SolutionTest {
    
    @Test
    public void testAddTwoNumbers() {
        Solution s = new Solution();
        ListNode res = s.addTwoNumbers(getListNode(5), getListNode(5));
        print(res);
    }
    
    private void print(ListNode ln) {
        while(ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
    ListNode getListNode(int number) {
        if(number < 10) {
            return new ListNode(number);
        } else {
            ListNode ln = new ListNode(number % 10);
            ln.next = getListNode(number /10);
            return ln;
        }
    }
}
