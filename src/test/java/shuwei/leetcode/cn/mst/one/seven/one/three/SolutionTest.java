package shuwei.leetcode.cn.mst.one.seven.one.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(7, s.respace(new String[]{"looked","just","like","her","brother"}, "jesslookedjustliketimherbrother"));
        Assert.assertEquals(2, s.respace(new String[]{"qowhxw","gobaagbtt","boh","eaqr","ghahqhqungoafnahwwhav","w","nvqx","obqhaxha","aew"}, "nvqxonnvqx"));
        Assert.assertEquals(63, s.respace(new String[]{"wccm","wiw","uwwiwcmiiiwmmwicuwu","mw"}, "iwiwwwmuiccwwwwwmumwwwmcciwwuiwcicwwuwicuiwciwmiwicwuwwmuimccwucuuim"));
    }
}
