package synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Created by pjajara on 2/15/17.
 */
public class ThreadKitchenSink {

    private int counter = 0;
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadKitchenSink kitchenSink = new ThreadKitchenSink();
        kitchenSink.foo();
        System.out.println("Counter: " + kitchenSink.counter);
    }

    public void foo() {
        ExecutorService service = Executors.newFixedThreadPool(100);
        IntStream.range(0, 100).forEach(i -> service.submit(task));
        service.shutdown();
    }

    Runnable task = () -> {

        lock.lock();

        try {
            counter++;
        } finally {
            lock.unlock();
        }
    };
}
