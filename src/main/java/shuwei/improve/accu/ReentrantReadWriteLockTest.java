package shuwei.improve.accu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {

        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
        new Worker("R1", readLock).start();
        new Worker("R2", readLock).start();
        new Worker("W1", writeLock).start();
        new Worker("W2", writeLock).start();
        new Worker("W3", writeLock).start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Worker("R3", readLock).start();
    }

    private static class Worker extends Thread {

        private final Lock lock;

        private Worker(String name, Lock lock) {
            super(name);
            this.lock = lock;
        }

        public void run() {
            try {
                lock.lock();
                System.out.println("Enter:" + getName() + ":" + (System.currentTimeMillis() / 1000));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Leave:" + getName() + ":" + (System.currentTimeMillis() / 1000));
                lock.unlock();
            }
        }
    }
}

