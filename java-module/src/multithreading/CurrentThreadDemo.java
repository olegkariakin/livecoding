package multithreading;

public class CurrentThreadDemo {

    static void main() {
        Thread t = Thread.currentThread();

        System.out.println("Current thread: " + t);

        t.setName("My Thread");
        System.out.println("After name change: " + t);

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Main thread interrupted");
    }
}
