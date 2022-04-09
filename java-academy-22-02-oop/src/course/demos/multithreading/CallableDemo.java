package course.demos.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class SearchTask implements Callable<String> {
    private String keywords;
    public SearchTask(String keywords) {
        this.keywords = keywords;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(new Random().nextInt(10000));
        return String.format("Search search for '%s' ...%n", keywords);
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executor = Executors.newCachedThreadPool();
        var completionService = new ExecutorCompletionService<String>(executor);
        var keywords = List.of("java", "jdk", "CompletableFuture", "multithreading", "lambda", "StreamAPI");
        List<Future> futures = new ArrayList<>();
        for(var kw : keywords) {
            var future = completionService.submit(new SearchTask(kw));
            futures.add(future);
        }

        // wait for all futures to complete
        for(int i = 0; i < futures.size(); i++) {
            System.out.println(completionService.take().get());
        }
        shutdownAndAwaitTermination(executor);
    }

    static void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(5, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
