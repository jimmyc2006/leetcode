package shuwei.improve.base;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;

public class FileTest {

    @Test
    public void sizeTest() throws IOException {
        File f = new File("D://aa.txt");
        System.out.println("new:" + f.length());
        FileWriter fw = new FileWriter(f);
        int totalSize = 0;
        for (int i = 0 ; i < 1000; i++){
            String str = "123dddddddddd,ee中文dddddddddddddddddddddddddddddddddddddddd" + IOUtils.LINE_SEPARATOR;
            totalSize += str.getBytes().length;
            fw.write(str);
        }
        fw.close();
        System.out.println("total write:" + f.length());
        System.out.println("tocal size:" + totalSize);
    }
}
