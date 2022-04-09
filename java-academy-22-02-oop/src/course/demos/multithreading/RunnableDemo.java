package course.demos.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableDemo {
    public static void main(String[] args) {
//        var executor = Executors.newFixedThreadPool(3);
//        var executor = Executors.newSingleThreadExecutor();
        var executor = Executors.newCachedThreadPool();
//        var executor = Executors.newScheduledThreadPool(4);
        for(int i = 0; i < 10; i++) {
//            new RocketLiftOff(i).run();
//            new Thread(new RocketLiftOff(i)).start();
            executor.execute(new RocketLiftOff(i));
//            executor.schedule(new RocketLiftOff(i), i , TimeUnit.SECONDS);
        }
    }
}
