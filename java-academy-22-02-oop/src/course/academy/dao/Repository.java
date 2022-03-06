package course.academy.dao;

import course.academy.exception.NonexistingEntityException;

import java.util.Collection;

/**
 * Public interface for managing lifecycle of entity objects
 */
public interface Repository<K, V extends Identifiable<K>> {
    /**
     * Find all users in repository
     * @return array of all users
     */
    Collection<V> findAll();

    /**
     * Find user by id
     * @param id the entity id
     * @return the user with given id, or null if id not found in repository
     */
    V findById(K id);
    V create(V entity);
    V update(V entity) throws NonexistingEntityException;
    V deleteById(K id) throws NonexistingEntityException;
    long count();
}
