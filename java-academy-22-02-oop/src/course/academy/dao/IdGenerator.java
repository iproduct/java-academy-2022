package course.academy.dao;

public interface IdGenerator<K> {
    K getNextId();
    K getCurrentId();
    void reset(K newInitialValue);
}
