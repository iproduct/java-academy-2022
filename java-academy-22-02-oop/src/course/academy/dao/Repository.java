package course.academy.dao;

import course.academy.dao.exception.InvalidRepositoryStateException;
import course.academy.model.User;

import java.util.List;

/**
 * Public interface for managing lifecycle of entity objects
 */
public interface Repository<K, V extends Identifiable<K>> {
    /**
     * Find all users in repository
     * @return array of all users
     */
    List<V> findAll();

    /**
     * Find user by id
     * @param id the entity id
     * @return the user with given id, or null if id not found in repository
     */
    V findById(K id);
    V create(V entity) throws InvalidRepositoryStateException;
    V update(V entity);
    V deleteById(K id);
    long count();
}
