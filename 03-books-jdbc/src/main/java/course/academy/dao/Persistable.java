package course.academy.dao;

public interface Persistable {
    /**
     * Load persisted data from external storage
     */
    void load();
    /**
     * Persists data to external storage
     */
    void save();
}
