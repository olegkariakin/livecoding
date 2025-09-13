package concurrent;

import java.util.concurrent.Semaphore;

public class SemDemo {
    static void main() {
        Semaphore semaphore = new Semaphore(1);

        new IncThread("A", semaphore);
        new DecThread("B", semaphore);
    }
}

class Shared {
    static int count = 0;
}

// Thread incrementing shared resource
class IncThread implements Runnable {
    String name;
    Semaphore semaphore;

    public IncThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        System.out.println("Launching " + name);

        try {
            // Acquire
            System.out.println(name + " waiting for acquire");
            semaphore.acquire();
            System.out.println(name + " acquired");

            // Accessing shared resource
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Releasing
        System.out.println(name + " releasing");
        semaphore.release();
    }
}

// Thread decrementing shared resource
class DecThread implements Runnable {
    String name;
    Semaphore semaphore;

    DecThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        System.out.println("Launching " + name);

        try {
            // First aquire
            System.out.println(name + " waiting for acquire");
            semaphore.acquire();
            System.out.println(name + " acquired");

            // Accessing share resource
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        // Releasing
        System.out.println(name + " releasing");
        semaphore.release();
    }
}