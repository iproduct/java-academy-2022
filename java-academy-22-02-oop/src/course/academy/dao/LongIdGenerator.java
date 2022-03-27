package course.academy.dao;

public class LongIdGenerator implements IdGenerator<Long> {
    private long lastId = 0;

    public LongIdGenerator() {
    }

    public LongIdGenerator(long initialValue) {
        this.lastId = initialValue;
    }

    @Override
    public Long getNextId() {
        return ++ lastId;
    }

    @Override
    public Long getCurrentId() {
        return lastId;
    }

    @Override
    public void reset(Long newInitialValue) {
        lastId = newInitialValue;
    }
}
