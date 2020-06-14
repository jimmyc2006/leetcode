package shuwei.improve.exec;

public class Test extends Thread {
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        t1.start();
        t2.start();
    }

    public static Object o = new Object();
    public static int obj = 1;

    @Override
    public void run() {
        while (obj < 100) {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + ":" + obj++);
                o.notify();
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (obj == 100) {
                    o.notify();
                }
            }
        }
    }
}
