package shuwei.improve.template;

public class IterBinaryBit {

  public static void main(String[] args) {
    int i1 = Integer.parseInt("1111", 2);
    binaryIter(i1);
  }

  public static void binaryIter(int num){
    System.out.println(Integer.toBinaryString(num));
    int tmp = (num - 1) & num;
    while (tmp != 0 && tmp != num) {
      System.out.println(Integer.toBinaryString(tmp));
      tmp = (tmp - 1) & num;
    }
  }
}
