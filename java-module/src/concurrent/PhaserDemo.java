package concurrent;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    static void main() {
        Phaser phaser = new Phaser(1);
        int currentPhase;

        System.out.println("Starting");

        new MyThread3(phaser, "A");
        new MyThread3(phaser, "B");
        new MyThread3(phaser, "C");
        new MyThread3(phaser, "D");

        // All threads await phase one
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase: " + currentPhase + " Complete");

        // All threads await phase two
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase: " + currentPhase + " Complete");

        // All threads await phase three
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase: " + currentPhase + " Complete");

        // Cancel main thread registration
        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) {
            System.out.println("The Phaser is terminated");
        }
    }
}

class MyThread3 implements Runnable {
    Phaser phaser;
    String name;

    MyThread3(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " Beginning Phase One");
        phaser.arriveAndAwaitAdvance();

        // Little pause for demo purpose only for consistent messages output
        // Not required for phaser's correct work
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Two");
        phaser.arriveAndAwaitAdvance();

        // Same technical pause for output only
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Three");
        phaser.arriveAndAwaitAdvance();
    }
}
