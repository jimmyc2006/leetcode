package shuwei.improve.bag;
/** 
* @author shuwei 
* @version 创建时间：2020年4月24日 上午8:56:04 
* 类说明 
*/

import java.util.Map;

import org.junit.Test;


public class Bag1Test {
  
  @Test
  public void test() {
    Bag1 b = new Bag1();
    Map<Integer, int[]> init = b.init();
    int max = b.bagProRecursion(b.init(), init.size(), 20);
    System.out.println(max);
    System.out.println(b.bagPro(init, 20));
  }
  
  @Test
  public void test2() {
    Bag1 b = new Bag1();
//    System.out.println(b.bagArr(20));
    System.out.println(b.bagArrMy(20));
  }
}
