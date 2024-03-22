package xyz.lcx.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-22
 */
class ConcurrentPrintTextTest {

    @Test
    void printTest1() {
        Object lock = new Object();
        String[] queue1 = new String[]{"a", "b", "c"};
        String[] queue2 = new String[]{"1", "2", "3"};

        new Thread(() -> {
            for (String s : queue1) {
                synchronized (lock) {
                    System.out.println(s);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "queue1").start();

        new Thread(() -> {
            for (String s : queue2) {
                synchronized (lock) {
                    System.out.println(s);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "queue2").start();
    }

    @Test
    void printTest2() {
        ReentrantLock lock = new ReentrantLock();
        Condition printCond = lock.newCondition();
        String[] queue1 = new String[]{"a", "b", "c"};
        String[] queue2 = new String[]{"1", "2", "3"};

        new Thread(() -> {
            for (String s : queue1) {
                lock.lock();
                System.out.println(s);
                try {
                    printCond.signal();
                    printCond.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "queue1").start();

        new Thread(() -> {
            for (String s : queue2) {
                lock.lock();
                System.out.println(s);
                try {
                    printCond.signal();
                    printCond.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "queue2").start();
    }
}
