package shuwei.improve.juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 测试获取unsafe和简单的使用
 */
public class UnsafeTest {

  static Unsafe unsafe;

  static {
    try {
      Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
      theUnsafe.setAccessible(true);
      unsafe = (Unsafe) theUnsafe.get(null);
      System.out.println(unsafe);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//    testSetFiled();
//    operateArray();
    testCas();
  }

  /**
   * compate跟put类似，只是会多一个原值的操作
   */
  public static void testCas() throws NoSuchFieldException {
    User user = new User();
    user.setId(1);
    user.setGender("Male");
    user.setName("shuwei");
    Field name = user.getClass().getDeclaredField("name");
    long l = unsafe.objectFieldOffset(name);
    System.out.println("src:" + user);
    System.out.println(unsafe.compareAndSwapObject(user, l, "shuwei", "super shuwei"));
    System.out.println("dst:" + user);
  }

  /**
   * unsafe对数组的操作比对象的偏移量多一个表示成员位置的偏移量
   */
  public static void operateArray() {
    int[] arr = new int[10];
    int baseOffset = unsafe.arrayBaseOffset(arr.getClass());
    int indexOffset = unsafe.arrayIndexScale(arr.getClass());
    System.out.println("init :" + Arrays.toString(arr));
//    unsafe.putInt(arr, baseOffset + indexOffset, 100);
    System.out.println("after:" + Arrays.toString(arr));
  }

  public static void testSetFiled() throws NoSuchFieldException {
    User user = new User();
    user.setId(1);
    user.setGender("Male");
    user.setName("shuwei");
    System.out.println("操作之前:" + user);

    /**
     * Unsafe的一般操作分为3步
     * 获取对象的Filed
     * 获取对象属性的offset
     * 设置对象属性的offset
     */
    Field nameFiled = user.getClass().getDeclaredField("name");
    long l = unsafe.objectFieldOffset(nameFiled);
    unsafe.putObject(user, l, "super shuwei");
    System.out.println("操作完成以后:" + user);
  }
}

class User {
  private long id;
  private String gender;
  private String name;

  public void setId(long id) {
    this.id = id;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", gender='" + gender + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}