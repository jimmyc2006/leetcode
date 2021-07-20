package shuwei.leetcode.cn.eight.two;

import org.junit.Test;
import shuwei.leetcode.cn.ListNode;

public class SolutionTest {

    @Test
    public void test(){
        Solution s = new Solution();
        ListNode listNode = s.deleteDuplicates(ListNode.gen("1,2,3,3,4,4,5"));
        System.out.println(listNode.b2String());
    }

    @Test
    public void test2(){
        Solution s = new Solution();
        ListNode listNode = s.deleteDuplicates(ListNode.gen("1"));
        System.out.println(listNode.b2String());
    }

    @Test
    public void test3(){
        Solution s = new Solution();
        ListNode result = s.deleteDuplicates(ListNode.gen("1,1"));
        System.out.println(result == null ? result : result.b2String());
    }
}
