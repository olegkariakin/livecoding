package multithreading;

public class NewThreadDemo {

    static void main() {
        NewThread t1 = new NewThread();

        for (int i = 5; i > 0; i--) {
            System.out.println("Main Thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Main Thread interrupted");
            }
        }
        System.out.println("Main Thread Done");
    }
}

class NewThread implements Runnable {
    Thread t;
    public NewThread() {
        t = new Thread(this, "Demo thread");
        System.out.println("Child thread created: " + t);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Child thread: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Child thread interrupted");
            }
        }
        System.out.println("Child thread exiting");
    }

}
