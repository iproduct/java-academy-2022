package course.demos.multithreading;

public class SafeSequenceSynchronized {
    private long nextId = 0;

    public synchronized long incrementAndGetNextId() {
        return ++nextId;
    }
    public synchronized long getNextId() {
        return nextId;
    }

}
