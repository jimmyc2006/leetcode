package shuwei.improve.base.generic;

public class Comparator<T> {

  // 普通方法可以使用类上面定义的范型
  public void objectPrint(T t) {
    System.out.println(t);
  }

  // 普通方法可以使用方法声明的范型
  public <Y> void classPrint(Y y) {
    System.out.println(y);
  }

  // 静态方法只能使用自己声明范型，不能使用类声明的，因为此时类可能没实例化
  public static <T> void clazzPrint(T t) {
    System.out.println(t);
  }
}
