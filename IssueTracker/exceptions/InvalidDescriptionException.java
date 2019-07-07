package exceptions;

public class InvalidDescriptionException extends RuntimeException {
    public InvalidDescriptionException(String message) {
        super(message);
    }
}
