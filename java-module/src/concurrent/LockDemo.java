package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    static void main() {
        ReentrantLock lock = new ReentrantLock();

        new LockThread(lock, "A");
        new LockThread(lock, "B");
        new LockThread(lock, "C");
        new LockThread(lock, "D");
    }
}

class Shared2 {
    static int count = 0;
}

class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    LockThread(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        System.out.println("Launch " + name);

        try {
            // First block counter.
            System.out.println(name + " waiting blocking counter.");
            lock.lock();
            System.out.println(name + " blocking counter.");
            Shared2.count++;
            System.out.println(name + ": " + Shared2.count);
            // Now if it is possible to allow context switching.
            System.out.println(name + " waiting");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            // Unlock
            System.out.println(name + " unlocking counter.");
            lock.unlock();
        }
    }
}
