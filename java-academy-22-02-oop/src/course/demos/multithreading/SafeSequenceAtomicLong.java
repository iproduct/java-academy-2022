package course.demos.multithreading;

import java.util.concurrent.atomic.AtomicLong;

public class SafeSequenceAtomicLong {
    private AtomicLong nextId = new AtomicLong(0);

    public long incrementAndGetNextId() {
        return nextId.incrementAndGet();
    }
    public long getNextId() {
        return nextId.get();
    }

}
