package shuwei.improve.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockChange {
  public static void main(String[] args) {
    Run.commonNumber = 0;
    Run.turnNumber = 3;
    Run.maxNumber = 100;

    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    new Thread(new Run(0, lock, condition1, condition2, "AAA"), "t1").start();
    new Thread(new Run(1, lock, condition2, condition3, "BBB"), "t2").start();
    new Thread(new Run(2, lock, condition3, condition1, "CCC"), "t3").start();
  }
}

class Run implements Runnable {
  static int commonNumber;
  static int maxNumber;
  static int turnNumber;

  private int currentThreadNumber;
  private ReentrantLock lock;
  private Condition currentConditon;
  private Condition nextCondition;
  private String message;

  public Run(int currentThreadNumber, ReentrantLock lock, Condition currentConditon, Condition nextCondition, String message) {
    this.currentThreadNumber = currentThreadNumber;
    this.lock = lock;
    this.currentConditon = currentConditon;
    this.nextCondition = nextCondition;
    this.message = message;
  }

  @Override
  public void run() {
    while (commonNumber < maxNumber) {
      try {
        lock.lock();
        if (commonNumber % turnNumber != currentThreadNumber) {
          currentConditon.await();
        }
        if (commonNumber >= maxNumber) {
          nextCondition.signal();
          return;
        }
        System.out.println(Thread.currentThread().getName() + " : " + commonNumber + " -> " + this.message);
        commonNumber++;
        nextCondition.signal();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }
}
