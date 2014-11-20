package cz.muni.fi.pb162.project.db;

/**
 * Represents exception when trying to reach database
 *
 * @author Wallecnik
 * @version 13.11.2014
 */
public class DbUnreachableException extends DbException {

    /**
     * Constructor of this exception
     *
     * @param message message to be said in exception
     * @param cause   cause that caused the exception
     */
    public DbUnreachableException(String message, Throwable cause) {
        super(message, cause);
    }
}
