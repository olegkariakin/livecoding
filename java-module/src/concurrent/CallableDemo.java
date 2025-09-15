package concurrent;

import java.util.concurrent.*;

public class CallableDemo {
    static void main() {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> f;
        Future<Double> f2;
        Future<Integer> f3;

        System.out.println("Launching");

        f = es.submit(new Sum(10));
        f2 = es.submit(new Hypot(3, 4));
        f3 = es.submit(new Factorial(5));

        try {
            System.out.println(f.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }

        es.shutdown();
        System.out.println("Completed");
    }
}

class Sum implements Callable<Integer> {
    int stop;

    Sum(int v) {
        stop = v;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}

class Hypot implements Callable<Double> {
    double side1, side2;

    Hypot(double s1, double s2) {
        this.side1 = s1;
        this.side2 = s2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt((this.side1 * this.side1) + (this.side2 * this.side2));
    }
}

class Factorial implements Callable<Integer> {
    int stop;

    Factorial(int v) {
        stop = v;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i <= stop; i++) {
            fact *= i;
        }
        return fact;
    }
}

