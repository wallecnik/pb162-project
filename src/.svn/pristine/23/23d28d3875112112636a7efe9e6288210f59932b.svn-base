package cz.muni.fi.pb162.project.db;

import java.io.IOException;

/**
 * This interface represents connection established with a remote host.
 * 
 * @author Radek Oslejsek &lt;oslejsek&amp;fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 * @author Tomas Pitner
 * @author Petr Adamek
 */
public interface Connection {
    
    /**
     * Enables to send a data to the remote host.
     * 
     * @param data data to be sent
     * @throws IOException indicates that an error occured while sending data
     * to the remote host (usually due to a temporary network failure).
     */
    void sendData(Object data) throws IOException;
    
}
