package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    static void main() {
        new AtomThread("A");
        new AtomThread("B");
        new AtomThread("C");
    }
}

class Shared3 {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomThread implements Runnable {
    String name;
    AtomThread(String name) {
        this.name = name;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        System.out.println("Launching " + name);
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " received: " + Shared3.ai.getAndSet(i));
        }
    }
}
