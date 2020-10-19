package shuwei.improve.base.generic;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class CodeTest {

  @Test
  public void test1() throws UnsupportedEncodingException {
    byte[] gb2312s = "侃".getBytes("GB2312");
    for (byte ele : gb2312s) {
      System.out.println(Byte.toUnsignedInt(ele));
    }
  }
}
