package multithreading;

public class JoinDemo {

    static void main() {
        JoinThread jt1 = new JoinThread("One");
        JoinThread jt2 = new JoinThread("Two");
        JoinThread jt3 = new JoinThread("Three");

        System.out.println("Thread One launched: " + jt1.thread.isAlive());
        System.out.println("Thread Two launched: " + jt2.thread.isAlive());
        System.out.println("Thread Three launched: " + jt3.thread.isAlive());

        try {
            System.out.println("Waiting for threads to accomplished");
            jt1.thread.join();
            jt2.thread.join();
            jt3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Is Thread One Alive: " + jt1.thread.isAlive());
        System.out.println("Is Thread Two Alive: " + jt2.thread.isAlive());
        System.out.println("Is Thread Three Alive: " + jt3.thread.isAlive());

        System.out.println("Main thread accomplished");
    }
}

class JoinThread implements Runnable {
    String name;
    Thread thread;

    JoinThread(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("New thread: " + thread);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted");
            }
        }
        System.out.println(name + " accomplished");
    }
}
