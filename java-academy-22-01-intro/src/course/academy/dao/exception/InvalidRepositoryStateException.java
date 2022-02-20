package course.academy.dao.exception;

public class InvalidRepositoryStateException extends Exception {
    public InvalidRepositoryStateException() {
        super();
    }

    public InvalidRepositoryStateException(String message) {
        super(message);
    }

    public InvalidRepositoryStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRepositoryStateException(Throwable cause) {
        super(cause);
    }
}
