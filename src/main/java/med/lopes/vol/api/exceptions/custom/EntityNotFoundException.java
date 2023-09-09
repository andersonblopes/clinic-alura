package med.lopes.vol.api.exceptions.custom;

/**
 * The type Entity didn't find exception.
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * Instantiates a new Entity not found exception.
     *
     * @param message the message
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
