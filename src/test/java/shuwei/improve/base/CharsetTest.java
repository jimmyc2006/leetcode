package shuwei.improve.base;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharsetTest {

    @Test
    public void test1() throws UnsupportedEncodingException {
        byte[] bytes = {-72, -33, -52, -6, -43, -66};
        String strUTF8 = new String(bytes, "UTF-8");
        System.out.println(strUTF8);
        byte[] bytes2 = strUTF8.getBytes("UTF-8");
        System.out.println(Arrays.toString(bytes2));
    }

}
