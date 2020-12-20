package shuwei.leetcode.cn.three.one.six;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

public class SolutionTest {

    @Test
    public void test(){
        Solution s = new Solution();
        Assert.assertEquals("acdb", s.removeDuplicateLetters("cbacdcbc"));
        Assert.assertEquals("ciorhsaebpunvdyktzfjlgwq", s.removeDuplicateLetters("yioccqiorhtoslwlvfgzycahonecugtatbyphpuunwvaalcpndabyldkdtzfjlgwqk"));
        Assert.assertEquals("abc", s.removeDuplicateLetters("abacb"));
        Assert.assertEquals("acdb", s.removeDuplicateLetters("cbacdcbc"));
        Assert.assertEquals("abc", s.removeDuplicateLetters("bcabc"));
    }

    @Test
    public void testTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(6);
        treeSet.add(1);
        treeSet.add(8);
        System.out.println(treeSet.higher(5));
        System.out.println(treeSet);
        System.out.println(treeSet.higher(6));
        System.out.println(treeSet.higher(9));
    }
}
