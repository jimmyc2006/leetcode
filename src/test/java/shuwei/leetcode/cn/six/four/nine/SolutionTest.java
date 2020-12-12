package shuwei.leetcode.cn.six.four.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("Radiant", s.predictPartyVictory("DRRDRDRDRDDRDRDR"));
        Assert.assertEquals("Dire", s.predictPartyVictory("DDRRR"));
        Assert.assertEquals("Dire", s.predictPartyVictory("DR"));
        Assert.assertEquals("Radiant", s.predictPartyVictory("RD"));
        Assert.assertEquals("Dire", s.predictPartyVictory("RDD"));
    }
}
