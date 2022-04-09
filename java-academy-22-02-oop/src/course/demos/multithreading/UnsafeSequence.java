package course.demos.multithreading;

public class UnsafeSequence {
    private long nextId = 0;

    public long incrementAndGetNextId() {
        return ++nextId;
    }
    public long getNextId() {
        return nextId;
    }

}
