package cz.muni.fi.pb162.project.db;

/**
 * This interface handles the persistent storage of graphical objects.
 * 
 * @author Radek Oslejsek &lt;oslejsek&amp;fi.muni.cz&gt;, 
 * Masaryk University, Faculty of Informatics
 */
public interface Storage {
    
    /**
     * Stores data in remote Db server.
     * 
     * @param host Address of remote DB server
     * @param data Data to store
     * @throws DbUnreachableException if DB is unreachable
     * @throws CannotStoreException if the method failed during the storing data into DB 
     */
    void store(String host, Object data) throws DbUnreachableException, CannotStoreException;
    
}
