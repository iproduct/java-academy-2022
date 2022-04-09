package course.demos.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SequenceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var seq = new SafeSequenceSynchronized();
        var executor = Executors.newCachedThreadPool();
        List<Future> futures = new ArrayList<>();
        for (long i = 0; i < 100L; i++) {
            futures.add(executor.submit(() -> {
                var sum = 0L;
                for (long j = 0; j < 10000L; j++) {
                    seq.incrementAndGetNextId();
                }
            }));
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
//        Thread.sleep(2000);
        for(int i = 0; i < futures.size(); i++) {
            futures.get(i).get();
        }
        System.out.println("Generated IDs number: " + seq.getNextId());
    }
}
