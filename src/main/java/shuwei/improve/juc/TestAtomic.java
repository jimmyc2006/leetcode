package shuwei.improve.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性和CountDownLatch
 */
public class TestAtomic {
  static AtomicInteger val = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {
    int threadCount = 10;
    CountDownLatch cdl = new CountDownLatch(threadCount);
    for (int i = 0; i < threadCount; i++) {
      Thread t = new Thread(new Test(cdl));
      t.start();
    }
    cdl.await();
    System.out.println(TestAtomic.val.get());
  }

}

class Test implements Runnable {
  CountDownLatch cdl;
  public Test (CountDownLatch cdl) {
      this.cdl = cdl;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100000; i++) {
      TestAtomic.val.getAndIncrement();
    }
    cdl.countDown();
  }
}
