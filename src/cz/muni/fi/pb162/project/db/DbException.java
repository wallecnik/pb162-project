package cz.muni.fi.pb162.project.db;

/**
 * Represents general fail when working with database
 *
 * @author Wallecnik
 * @version 13.11.2014
 */
public class DbException extends Exception {

    /**
     * Constructor of this exception
     *
     * @param message message to be said in exception
     * @param cause   cause that caused the exception
     */
    public DbException (String message, Throwable cause) {
        super(message, cause);
    }

}
