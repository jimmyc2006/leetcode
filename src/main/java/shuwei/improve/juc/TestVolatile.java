package shuwei.improve.juc;

public class TestVolatile {
  public static void main(String[] args) throws InterruptedException {
    ValTest vt = new ValTest();
    Thread t1 = new Thread(vt);
    t1.start();
    synchronized (vt) {
      while(!vt.isRunning) {
      }
    }
    System.out.println("main over");
  }

}

class ValTest implements Runnable {
  boolean isRunning = false;
  @Override
  public void run() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//    synchronized (this) {
      this.isRunning = true;
//    }
    System.out.println("is:" + isRunning);
  }
}
