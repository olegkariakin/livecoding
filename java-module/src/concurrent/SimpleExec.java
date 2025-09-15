package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExec {

    static void main() {
        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        try(ExecutorService es = Executors.newFixedThreadPool(2)) {
            System.out.println("Launch");

            // Thread start
            es.execute(new MyThread5("A", cdl1));
            es.execute(new MyThread5("B", cdl2));
            es.execute(new MyThread5("C", cdl3));
            es.execute(new MyThread5("D", cdl4));

            try {
                cdl1.await();
                cdl2.await();
                cdl3.await();
                cdl4.await();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        //es.shutdown();
        System.out.println("Accomplishment");
    }
}

class MyThread5 implements Runnable {
    String name;
    CountDownLatch countDownLatch;

    MyThread5(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            countDownLatch.countDown();
        }
    }
}
