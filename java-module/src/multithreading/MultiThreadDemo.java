package multithreading;

public class MultiThreadDemo {

    public static void main(String[] args) {
        new MultiThread("One");
        new MultiThread("Two");
        new MultiThread("Three");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread accomplished");
    }
}

class MultiThread implements Runnable {
    String name;
    Thread thread;

    MultiThread(String name) {
        this.name = name;
        thread = new Thread(this, this.name);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(this.name + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(this.name + "Interrupted");
            }
        }
        System.out.println(this.name + " Accomplished");
    }
}
