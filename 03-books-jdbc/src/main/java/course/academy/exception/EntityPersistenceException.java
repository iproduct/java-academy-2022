package course.academy.exception;

public class EntityPersistenceException extends RuntimeException{
    public EntityPersistenceException() {
    }

    public EntityPersistenceException(String message) {
        super(message);
    }

    public EntityPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityPersistenceException(Throwable cause) {
        super(cause);
    }
}
