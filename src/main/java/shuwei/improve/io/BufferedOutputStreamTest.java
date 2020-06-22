package shuwei.improve.io;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class BufferedOutputStreamTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        File f = new File("E:\\aa/test.txt");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream((f)));
        for (int i = 0; i < 1000000; i++){
            String line = i + " aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            bos.write(line.getBytes());
            bos.write("\n".getBytes());
            Thread.sleep(1000);
            if (i % 5 == 0) {
                bos.flush();
            }
        }
    }
}
