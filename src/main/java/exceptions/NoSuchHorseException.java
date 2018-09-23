package exceptions;

public class NoSuchHorseException extends RuntimeException {
    public NoSuchHorseException(String message) {
        super(message);
    }
}
