package multithreading;

public class ExtendThreadDemo {

    static void main() {
        new ExtendThread();
        new ExtendThread();

        for (int i = 5; i > 0; i--) {
            System.out.println("Main thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Main thread ended");
    }
}

class ExtendThread extends Thread {
    ExtendThread() {
        super("ExtendThread");
        System.out.println("Child thread: " + this.getName());
        start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Child thread: " + i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Child thread interrupted");
            }
        }
        System.out.println("Child thread accomplished");
    }
}
