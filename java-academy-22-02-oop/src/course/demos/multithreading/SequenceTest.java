package course.demos.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class SequenceTest {
    public static void main(String[] args) throws InterruptedException {
        var seq = new SafeSequenceSynchronized();
        var executor = Executors.newCachedThreadPool();
        for (long i = 0; i < 100L; i++) {
            executor.execute( () -> {
                var sum = 0L;
                for (long j = 0; j < 10000L; j++) {
                    seq.incrementAndGetNextId();
                }
            });
//                    new Runnable() {
//                        @Override
//                        public void run() {
//                            var sum = 0L;
//                            for (long j = 0; j < 1000L; j++) {
//                                sum += seq.incrementAndGetNextId();
//                            }
//                        }
//                    });
        }
        Thread.sleep(2000);
        System.out.println("Generated IDs number: " + seq.getNextId());
    }
}
