package concurrent;

import java.util.concurrent.Semaphore;

class Q {
    int n;

    // Starting from unaccessed Semaphore consumer
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(STR."Received: \{n}");
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        this.n = n;
        System.out.println(STR."Sent: \{n}");
        semCon.release();
    }
}

class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.put(i);
        }
    }
}

class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.get();
        }
    }
}

public class ProducerConsumerQueue {
    static void main() {
        Q q = new Q();
        new Consumer(q);
        new Producer(q);
    }
}
