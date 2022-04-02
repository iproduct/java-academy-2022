package course.academy.dao;

import course.academy.exception.NonexistingEntityException;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Public interface for managing lifecycle of entity objects
 */
public interface Repository<K, V extends Identifiable<K>> {

    /**
     * Find all users in repository
     * @return array of all users
     */
    Collection<V> findAll() throws SQLException;

    List<V> findAllSorted(Comparator<V> comparator);

    /**
     * Find user by id
     * @param id the entity id
     * @return the user with given id, or null if id not found in repository
     */
    V findById(K id);
    default V findById(K id, Class<V> cls){
        System.out.println("Doing something with class " + cls.getSimpleName());
        return findById(id);
    }

    V create(V entity);
    void addAll(Collection<V> entities);
    void clear();
    V update(V entity) throws NonexistingEntityException;
    V deleteById(K id) throws NonexistingEntityException;
    long count();
}
