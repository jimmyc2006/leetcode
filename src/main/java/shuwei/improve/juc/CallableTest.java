package shuwei.improve.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
  /**
   * FutureTask的get方法会阻塞
   * @param args
   * @throws ExecutionException
   * @throws InterruptedException
   */
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    FutureTask<String> ft1 = new FutureTask<>(new MyCallable(1000));
    FutureTask<String> ft2 = new FutureTask<>(new MyCallable(2000));
    new Thread(ft1).start();
    new Thread(ft2).start();
    while (true) {
      System.out.println("ft1.get():" + ft1.get());
      System.out.println("ft2.get():" + ft2.get());
      Thread.sleep(200);
    }
  }

}

class MyCallable implements Callable<String> {

  private long sleepTimes;

  public MyCallable (long time) {
    this.sleepTimes = time;
  }

  @Override
  public String call() throws Exception {
    Thread.sleep(sleepTimes);
    return "sleep:" + sleepTimes;
  }

}
