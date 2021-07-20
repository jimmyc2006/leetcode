package shuwei.leetcode.cn.one.six.zero.three;

public class ParkingSystem {

  private final int TYPE_BIG = 1;
  private final int TYPE_MEDIUM = 2;
  private final int TYPE_SMALL = 3;
  private int big;
  private int medium;
  private int samll;

  public ParkingSystem(int big, int medium, int small) {
    this.big = big;
    this.medium = medium;
    this.samll = small;
  }

  public boolean addCar(int carType) {
    switch (carType) {
      case TYPE_BIG:
        if (big > 0) {
          big--;
          return true;
        }
        return false;
      case TYPE_MEDIUM:
        if (medium > 0) {
          medium--;
          return true;
        }
        return false;
      case TYPE_SMALL:
        if (samll > 0) {
          samll--;
          return true;
        }
        return false;
      default:
        return false;

    }
  }
}
