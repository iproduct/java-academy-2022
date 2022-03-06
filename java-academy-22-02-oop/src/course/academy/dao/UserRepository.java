package course.academy.dao;

import course.academy.model.User;

/**
 * Public interface for managing lifecycle of User objects
 */
public interface UserRepository extends Repository<Long, User>{
    User findByUsername(String username);
}
