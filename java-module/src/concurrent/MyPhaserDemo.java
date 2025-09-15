package concurrent;

import java.util.concurrent.Phaser;

public class MyPhaserDemo {
    static void main() {
        MyPhaser myPhaser = new MyPhaser(1, 4);
        System.out.println("Starting\n");

        new MyThread4(myPhaser, "A");
        new MyThread4(myPhaser, "B");
        new MyThread4(myPhaser, "C");

        // Wait for some phase count to accomplish
        while (!myPhaser.isTerminated()) {
            myPhaser.arriveAndAwaitAdvance();
        }

        System.out.println("The Phaser is terminated");
    }
}

// Extending Phaser that allows to run specific phases quantity
class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        this.numPhases = phaseCount - 1;
    }

    // Override to run specific number of phases
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Phase " + phase + " completed.\n");

        // If all phases completed return true
        return phase == numPhases || registeredParties == 0;
    }
}

class MyThread4 implements Runnable {
    Phaser phaser;
    String name;

    MyThread4(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        this.phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phaser.isTerminated()) {
            System.out.println("Thread " + name + " Beginning phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();

            // Optional pause for correct console output, not required for correct phaser work
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
