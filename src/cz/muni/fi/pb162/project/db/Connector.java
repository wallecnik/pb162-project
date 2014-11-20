package cz.muni.fi.pb162.project.db;

import java.net.NoRouteToHostException;
import java.net.UnknownHostException;

/**
 * This interface handles connection to the remote host.
 * 
 * @author Radek Oslejsek &lt;oslejsek&amp;fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public interface Connector {
    
    /**
     * Establishes connection to remote host.
     * 
     * @param host remote host address
     * @return Established connection with the remote host
     * @throws UnknownHostException Indicates that the host address does not exist
     * @throws NoRouteToHostException Signals that an error occurred while 
     * attempting to connect a socket to a remote address.
     */
    Connection getConnection(String host) 
            throws UnknownHostException, NoRouteToHostException;
}
