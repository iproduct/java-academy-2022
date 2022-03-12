package course.academy.dao;

/**
 * Allows to persist and load repository data to/from external storage
 */
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
