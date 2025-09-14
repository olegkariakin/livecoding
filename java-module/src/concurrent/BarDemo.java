package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    static void main() {
        CyclicBarrier barrier = new CyclicBarrier(2, new BarAction());

        System.out.println("Launch");

        new MyThread2(barrier, "A");
        new MyThread2(barrier, "B");
        new MyThread2(barrier, "C");
        new MyThread2(barrier, "X");
        new MyThread2(barrier, "Y");
        new MyThread2(barrier, "Z");
    }
}

class MyThread2 implements Runnable {
    CyclicBarrier barrier;
    String name;

    MyThread2(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(this.name + " is running");
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println(e);
        }
    }
}

class BarAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Barrier reached");
    }
}
