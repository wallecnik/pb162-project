package cz.muni.fi.pb162.project.db;

/**
 * Connection has been made, but all attempts of storing has failed
 *
 * @author Wallecnik
 * @version 13.11.2014
 */
public class CannotStoreException extends DbException {
    /**
     * Constructor of this exception
     *
     * @param message message to be said in exception
     * @param cause   cause that caused the exception
     */
    public CannotStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
