package shuwei.leetcode.cn.one.six.zero.three;

import org.junit.Assert;
import org.junit.Test;

public class ParkingSystemTest {

  @Test
  public void test() {
    ParkingSystem s = new ParkingSystem(1, 1, 0);
    Assert.assertTrue(s.addCar(1));
    Assert.assertTrue(s.addCar(2));
    Assert.assertFalse(s.addCar(3));
    Assert.assertFalse(s.addCar(1));
  }

}
