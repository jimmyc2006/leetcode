package shuwei.improve.juc;

public class OutputChange {
  public static void main(String[] args) {
    // 创建3个线程
    Out.commonNumber = 0;
    Out.maxNumber = 100;
    Out.turnNumber = 3;

    Object lock = new Object();
    Out o1 = new Out(lock, "A", 0);
    Out o2 = new Out(lock, "B", 1);
    Out o3 = new Out(lock, "C", 2);
    new Thread(o1, "t1").start();
    new Thread(o2, "t2").start();
    new Thread(o3, "t3").start();
  }
}

class Out implements Runnable {
  static int maxNumber;
  static int commonNumber;
  static int turnNumber;

  private Object lock;
  private String message;
  private int thisNumber;

  public Out(Object lock, String message, int thisNumber) {
    this.lock = lock;
    this.message = message;
    this.thisNumber = thisNumber;
  }

  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted() && commonNumber < maxNumber) {
      synchronized (lock) {
        while (commonNumber % turnNumber != this.thisNumber && commonNumber < maxNumber) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        if (commonNumber >= maxNumber) {
          return;
        }
        System.out.println(Thread.currentThread().getName() + " : " + commonNumber + " -> " + this.message);
        commonNumber++;
        lock.notifyAll();
      }
    }
  }
}